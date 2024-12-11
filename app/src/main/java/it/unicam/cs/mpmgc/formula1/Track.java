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

public class Track implements iTrack{

    private final int rows;
    private final int columns;
    private final char[][] track;
    private Position finish;

    public Track(int rows, int columns){
        this.rows = rows;
        this.columns = columns;
        this.track = new char[rows][columns];
    }

    @Override
    public void createTrack(List<String> trackLines) {
        for (int row = 0; row < rows ; row++){
            String line = trackLines.get(row);
            for (int column = 0; column < columns; column++ ){
                char cell = line.charAt(column);
                track[row][column] = cell;
                if (cell == 'F'){
                    finish = new Position(row, column);
                }
            }
        }
    }

    @Override
    public int getRows(){
        return rows;
    }

    @Override
    public int getColumns(){
        return columns;
    }

    @Override
    public Position getFinishLine() {
        return finish;
    }

    @Override
    public char[][] getTrack() {
        return track;
    }

}
