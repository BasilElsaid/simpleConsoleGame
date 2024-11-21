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

public class HumanCar implements iRacer {

    private final String name;
    private final Position currentPosition;
    private int speed = 1;

    public HumanCar(String name){
        this.name = name;
        this.currentPosition = new Position(0,0);
    }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public Position getCurrentPosition() {
        return currentPosition;
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    @Override
    public void UpdatePosition(Position newPosition) {
        currentPosition.setRow(newPosition.getRow());
        currentPosition.setColumn(newPosition.getColumn());
    }

    public void accelerate(){
        int row = currentPosition.getRow();
        int column = currentPosition.getColumn();
        speed++;
        Position nextMove = new Position(row, column +speed);
        UpdatePosition(nextMove);
    }

    public void decelerate(){
        int row = currentPosition.getRow();
        int column = currentPosition.getColumn();
        speed = 1;
        Position nextMove = new Position(row, column +speed);
        UpdatePosition(nextMove);
    }
}
