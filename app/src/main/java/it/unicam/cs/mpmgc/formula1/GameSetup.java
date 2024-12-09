/*
 * MIT License
 *
 * Copyright (c) 2024 Basil Elsaid
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package it.unicam.cs.mpmgc.formula1;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class GameSetup implements iGameSetup{

    private final List<iRacer> players = new ArrayList<>();
    private int playerIndex = 1;
    private final SimpleTrack track;

    public GameSetup(SimpleTrack track) {
        this.track = track;
    }

    @Override
    public void loadPlayers(){
        try {
            Path filePath = Path.of(getClass().getClassLoader().getResource("playersFile.txt").toURI());
            List<String> lines = Files.readAllLines(filePath);
            for (String line : lines) {
                String[] parts = line.split(",");
                if (parts.length != 2) {
                    System.out.println("Invalid entry in file" + line);
                    continue;
                }
                String type = parts[0].trim();
                String name = parts[1].trim();
                addAndUpdateRacer(type, name);
            }
        }   catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void addAndUpdateRacer(String playerType, String playerName) {

        iRacer player = null;
        iMovementStrategy strategy;
        switch (playerType) {
            case "Bot": {
                strategy = new BotMovementStrategy();
                player = new BotCar(playerName, track, strategy);
                break;
            }
            case "Human": {
                strategy = new HumanMovementStrategy();
                player = new HumanCar(playerName, track, strategy);
                break;
            }
        }
        player.UpdatePosition(new Position(playerIndex, 1));
        players.add(player);
        playerIndex++;
    }

    @Override
    public List<iRacer> getPlayers(){
        return players;
    }


    @Override
    public void placePlayer(iRacer player) {
        if (player instanceof BotCar){
            track.getTrack()[player.getCurrentPosition().getRow()]
                    [player.getCurrentPosition().getColumn()] = 'B';
        }
        else{
            track.getTrack()[player.getCurrentPosition().getRow()]
                    [player.getCurrentPosition().getColumn()] = 'P';
        }
    }

    @Override
    public void ResetCurrentPositionSymbol(iRacer player) {
        track.getTrack()[player.getCurrentPosition().getRow()]
                [player.getCurrentPosition().getColumn()] = '.';
    }

}
