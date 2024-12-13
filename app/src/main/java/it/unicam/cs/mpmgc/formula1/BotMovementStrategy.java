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

import java.util.Random;

public class BotMovementStrategy implements iMovementStrategy{

    private Directions nextDirection;
    private int speed;
    private final Track track;

    public BotMovementStrategy(Track track){
        this.nextDirection = Directions.RIGHT;
        this.speed = 1;
        this.track = track;
    }

    @Override
    public Position move(Position currentPosition) {
        Random random = new Random();
        speed = 1 + random.nextInt(2);
        Position newPos = nextDirection.move(currentPosition, speed);

        if (!checkValidMove(newPos)){
            switch (nextDirection){
                case RIGHT -> nextDirection = Directions.DOWN;
                case DOWN -> nextDirection = Directions.LEFT;
                case LEFT -> nextDirection = Directions.UP;
                case UP -> nextDirection = Directions.RIGHT;
            }
            newPos = nextDirection.move(currentPosition, speed);
            if (!checkValidMove(newPos)){ return currentPosition; }
        }

        return newPos;
    }

    @Override
    public boolean checkValidMove(Position move) {
        int row = move.getRow();
        int column = move.getColumn();
        if (move.getRow() <= 0 || move.getRow() >= track.getRows()
                || move.getColumn() <= 0 || move.getColumn() >= track.getColumns()){
            return false;
        }
        return track.getTrack()[row][column] == '_' || track.getTrack()[row][column] == '.';
    }

    @Override
    public int getSpeed(){
        return speed;
    }

    @Override
    public Directions getNextDirection(){
        return nextDirection;
    }

}