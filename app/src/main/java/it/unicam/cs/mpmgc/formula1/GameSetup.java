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

import java.util.ArrayList;
import java.util.List;

public class GameSetup{

    private final List<iRacer> players;
    private int playerIndex;
    private SimpleTrack track;
    private FileIO fileIO;

    public GameSetup(SimpleTrack track) {
        this.players = new ArrayList<>();
        this.playerIndex = 1;
        this.track = track;
        this.fileIO = new FileIO();
    }

    public void setupGame(){
        List<String> trackData = fileIO.readTrack();
        track.setTrackDimensions(fileIO.loadTrack(trackData));
        track.createTrack(trackData);
        setupPlayers(
                fileIO.loadPlayers(fileIO.readPlayers())
        );
        for (iRacer player : players){
            placePlayer(player);
        }
        track.displayTrack();
    }

    public void setupPlayers(List<String[]> playerData) {
        iRacer player = null;
        iMovementStrategy strategy;
        for (String[] pair : playerData){
            String playerType = pair[0];
            String playerName = pair[1];
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
                default: {
                    System.out.println(playerType + ": Type is not Bot/Human");
                    return;
                }
            }
            player.UpdatePosition(new Position(playerIndex, 1));
            players.add(player);
            playerIndex++;
        }
    }

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

    public void ResetCurrentPositionSymbol(iRacer player) {
        track.getTrack()[player.getCurrentPosition().getRow()]
                [player.getCurrentPosition().getColumn()] = '.';
    }

    public List<iRacer> getPlayers(){
        return players;
    }

}
