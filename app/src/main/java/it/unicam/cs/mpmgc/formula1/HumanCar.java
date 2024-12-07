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

import java.awt.*;
import java.util.Scanner;

public class HumanCar implements iRacer {

    private final String name;
    private final Position currentPosition;
    private int speed = 1;
    private SimpleTrack track;

    public HumanCar(String name, SimpleTrack track){
        this.name = name;
        this.currentPosition = new Position(0,0);
        this.track = track;
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

    @Override
    public void move() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your move: W:up, S:down, A:left, D:right");
        String move = scan.next();

        int row = currentPosition.getRow();
        int column = currentPosition.getColumn();
        Position newPos = null;

        switch (move){
            //TODO convert position to enum
            case "W" -> newPos = new Position(row-1, column);
            case "S" -> newPos = new Position(row+1, column);
            case "D" -> newPos = new Position(row, column+1);
            case "A" -> newPos = new Position(row, column-1);
            default -> {newPos = this.currentPosition;
                        System.out.println("Invalid Input, you lost a move.");}
            }
        if (checkValidMove(newPos) == true){
            UpdatePosition(newPos);
        }

    }

    @Override
    public boolean checkValidMove(Position move) {
        int row = move.getRow();
        int column = move.getColumn();
        if (track.getTrack()[row][column] != '.' || move == null) {
            System.out.println("Invalid Move");
            return false;
        }
        return true;
    }
}
