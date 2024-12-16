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

package it.unicam.cs.mpmgc.formula1.game;

import it.unicam.cs.mpmgc.formula1.utils.FileIO;
import it.unicam.cs.mpmgc.formula1.utils.Position;
import it.unicam.cs.mpmgc.formula1.players.iCar;
import it.unicam.cs.mpmgc.formula1.players.BotMovementStrategy;
import it.unicam.cs.mpmgc.formula1.players.Car;
import it.unicam.cs.mpmgc.formula1.players.HumanMovementStrategy;
import it.unicam.cs.mpmgc.formula1.track.Track;
import it.unicam.cs.mpmgc.formula1.track.TrackRenderer;

import java.util.ArrayList;
import java.util.List;

public class GameSetup{

    private final List<iCar> players;
    private int playerIndex;
    private Track track;
    private final FileIO fileIO;
    private final it.unicam.cs.mpmgc.formula1.track.TrackRenderer TrackRenderer;

    public GameSetup() {
        this.players = new ArrayList<>();
        this.playerIndex = 1;
        this.fileIO = new FileIO();
        this.TrackRenderer = new TrackRenderer();
    }

    public void setupGame(){
        fileIO.readAndParseFile();
        setupTrack();
        setupPlayers(fileIO.loadPlayers());
        for (iCar player : players){
            TrackRenderer.placePlayer(player, track);
        }
        TrackRenderer.displayTrack(track);
    }

    public void setupTrack(){
        int[] dimensions = fileIO.loadTrack();
        this.track = new Track(dimensions[0], dimensions[1]);
        track.createTrack(fileIO.getTrackLines());
    }

    public void setupPlayers(List<String[]> playerData) {
        for (String[] pair : playerData){
            iCar player = null;
            String playerType = pair[0];
            String playerName = pair[1];
            switch (playerType) {
                case "Bot": {
                    player = new Car(playerName, new BotMovementStrategy(track));
                    break;
                }
                case "Human": {
                    player = new Car(playerName, new HumanMovementStrategy(track));
                    break;
                }
                default: {
                    System.err.println(playerType + ": Type is not Bot/Human");
                    return;
                }
            }
            player.updatePosition(new Position(playerIndex, 1));
            players.add(player);
            playerIndex++;
        }
    }

    public List<iCar> getPlayers(){return players;}

    public Track getTrack(){ return track; }

}
