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

public class HumanMovementStrategy implements iMovementStrategy{

    private Directions lastDirection;
    private Directions nextDirection;
    private int speed;
    private final Track track;

    public HumanMovementStrategy(Track track){
        this.speed = 1;
        this.track = track;
    }

    @Override
    public Position move(Position currentPosition) {
        setNextDirection();
        if (nextDirection == null) {
            return currentPosition;
        }
        setSpeed();

        Position newPos = nextDirection.move(currentPosition, speed);
        if (!checkValidMove(newPos)){
            System.out.println("Invalid Move, stay at same position.");
            return currentPosition;
        }

        lastDirection = nextDirection;
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
    public Directions getNextDirection(){ return nextDirection; }

    public void setNextDirection(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your move: W:up, S:down, A:left, D:right");
        String move = scan.nextLine().toUpperCase();
        Directions direction = null;

        switch (move){
            case "W" :  direction = Directions.UP;
                        break;
            case "S" :  direction = Directions.DOWN;
                        break;
            case "D" :  direction = Directions.RIGHT;
                        break;
            case "A" :  direction = Directions.LEFT;
                        break;
            default  :  System.out.println("Invalid Input, stay at same position.");
        }
        nextDirection = direction;
    }

    public void setSpeed(){
        if (lastDirection == nextDirection){
            if (speed == 1) {
                speed = 2;
                System.out.println("Speed increased to 2 for keeping same direction.");
            }
        }
        else { speed = 1; }
    }



}
