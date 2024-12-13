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

import java.util.Scanner;

public class GamePlay implements iGamePlay {

    private boolean gameFinished;
    private final GameSetup gameSetup;
    private final Track track;
    private final ConsoleMessages messages;
    private final TrackRenderer trackRenderer;

    public GamePlay(GameSetup setup){
        this.gameFinished = false;
        this.gameSetup = setup;
        this.track = setup.getTrack();
        this.messages = new ConsoleMessages();
        this.trackRenderer = new TrackRenderer();
    }

    @Override
    public void startGame(){
        Scanner scan = new Scanner(System.in);
        messages.startGameMessage();
        while (!gameFinished) {
            for (iCar player : gameSetup.getPlayers()){
                executeTurn(player);
            }
            trackRenderer.displayTrack(track);
        }
        messages.endGameMessage();
        scan.close();
    }

    @Override
    public void endGame(){
        this.gameFinished = true;
    }

    @Override
    public void executeTurn(iCar player) {
        messages.playerTurnMessage(player);
        trackRenderer.ResetCurrentPositionSymbol(player, track);
        player.move();
        trackRenderer.move(player);
        trackRenderer.placePlayer(player, track);
        if (checkWinner(player)){
            endGame();
        }
    }

    @Override
    public boolean checkWinner(iCar player){
        for (Position position : track.getFinishLine()){
            if (player.getCurrentPosition().equals(position)){
                messages.winnerNameMessage(player);
                return true;
            }
        }
        return false;
    }

}
