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
     * creates the track from a given List of strings.
     * it also sets the final positions.
     */
    void createTrack(List<String> trackLines);

    /**
     * check if the move is in or out bounders before moving.
     * @param move the position to move to.
     * @return true if position is free to move/final position,
     *         false if position is out of bounders/occupied.
     */
    boolean checkValidMove(Position move);

    /**
     * @return the number of rows of the trackFormat.
     */
    public int getRows();

    /**
     * @return the number of columns of the trackFormat.
     */
    public int getColumns();

    /**
     * @return a list of positions where the finish line is placed.
     */
    List<Position> getFinishLine();

    /**
     * @return the track array.
     */
    char[][] getTrack();

}
