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

public class GamePlay extends GameSetup
        implements iGamePlay {

    private boolean gameFinished = false;
    private String winnerName = "";


    public GamePlay(){
    }

    @Override
    public void startGame(BotCar botCar1, BotCar botCar2, HumanCar car1, SimpleTrack track){
        while (gameFinished == false) {
            track.ResetCurrentPositionSymbol(getPlayersPositions());
            System.out.println("write 'a' to accelerate, 'd' to decelerate, 'q' to exit");
            Scanner scan = new Scanner(System.in);

            switch (scan.next()) {
                case "a" -> car1.accelerate();
                case "d" -> car1.decelerate();
                case "q" -> endGame();
                default -> System.out.println("Wrong Input!");
            }
            botCar1.calculateNextMove();
            botCar2.calculateNextMove();
            updateGame(track);
        }
    }

    @Override
    public void updateGame(SimpleTrack track) {
        track.placePlayers(getPlayersPositions());
        track.displayTrack();
        checkWinner(track);
    }

    @Override
    public void endGame(){
        this.gameFinished = true;
        if (winnerName == null){
            System.out.println("You quit the Game");
        }
        else {
            System.out.println("The winner is : " + winnerName);
        }
    }

    @Override
    public void checkWinner(SimpleTrack track){
        winnerName = track.crossedFinalLine(super.getPlayersPositions());
        if (winnerName != null){
            endGame();
        }
    }

}
