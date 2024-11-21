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

public interface iGamePlay {

    /**
     * starts the game
     * @param bot1 the first Bot car that will play
     * @param bot2 the second Bot Car that will play
     * @param car1 the Human Car "User" that will play the game
     * @param track the track of the game
     */
    void startGame(BotCar bot1, BotCar bot2, HumanCar car1, SimpleTrack track);

    /**
     * updates the state of the game
     * @param track the track to be updated
     */
    void updateGame(SimpleTrack track);

    /**
     * ends the game
     */
    void endGame();

    /**
     * gives the name of the winner
     * @param track the track where the players race
     */
    void checkWinner(SimpleTrack track);


}
