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

import java.util.List;

public interface iTrack {

    /**
     * creates the track from a reading text file.
     */
    void createTrack();

    /**
     * displays the track in the console, with eventual updates
     */
    void displayTrack();

    /**
     * it puts a letter on the start line of the track to indicate the racer:
     * "P" for HumanPlayer
     * "B" for BotPlayer
     * @param players a list the contains all the players' names and their positions.
     */
    void placePlayers(List<iRacer> players);

    /**
     * remove the car symbol from the current position before moving to a new one
     * @param players a list the contains all the players' names and their positions before moving
     */
    void ResetCurrentPositionSymbol(List<iRacer> players);

    /**
     * checks if a player acrossed the final line
     * @param players a list of the racers
     * @return name of th winner
     */
    String crossedFinalLine(List<iRacer> players);
}
