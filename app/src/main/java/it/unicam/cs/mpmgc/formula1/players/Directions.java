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

package it.unicam.cs.mpmgc.formula1.players;

import it.unicam.cs.mpmgc.formula1.utils.Position;

public enum Directions {

    UP(-1, 0),
    DOWN(1, 0),
    RIGHT(0, 1),
    LEFT(0, -1);

    private final int rowDifference;
    private final int columnDifference;

    Directions(int rowChange, int columnChange) {
        this.rowDifference = rowChange;
        this.columnDifference = columnChange;
    }

    /**
     * calculates the next position in base of current position, speed and direction.
     * @param currentPos the current position to move from.
     * @param speed the speed of movemet.
     * @return the new position to move to.
     */
    public Position move(Position currentPos, int speed){
        int newRow = currentPos.getRow() + this.rowDifference*speed;
        int newColumn = currentPos.getColumn() + this.columnDifference*speed;
        return new Position(newRow, newColumn);
    }
}
