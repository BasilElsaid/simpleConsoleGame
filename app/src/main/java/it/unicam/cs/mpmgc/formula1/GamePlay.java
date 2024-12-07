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

    private boolean gameFinished = false;
    private String winnerName = "Undefined";
    private GameSetup gameSetup;
    private SimpleTrack track;


    public GamePlay(GameSetup setup, SimpleTrack track){
        this.gameSetup = setup;
        this.track = track;
    }

    @Override
    public void startGame(){
        Scanner scan = new Scanner(System.in);
        while (gameFinished == false) {
            gameSetup.moveAndResetCurrentPositionSymbol();
            for (iRacer player : gameSetup.getPlayers()){
                System.out.println(player.getName() + "'s move: ");
                player.move();
            }
            updateGame();
        }
        scan.close();
    }

    @Override
    public void updateGame() {
        gameSetup.placePlayers();
        track.displayTrack();
        checkWinner();
    }

    @Override
    public void endGame(){
        this.gameFinished = true;
        if (winnerName == "Undefined"){
            System.out.println("You quit the Game");
        }
        else {
            System.out.println("The winner is : " + winnerName);
        }
    }

    @Override
    public void checkWinner(){
        if (winnerName != "Undefined"){
            for (iRacer player : gameSetup.getPlayers()){
                if (player.getCurrentPosition() == track.getFinishLine()){
                    winnerName = player.getName();
                    endGame();
                    break;
                }
            }
        }
    }


}
