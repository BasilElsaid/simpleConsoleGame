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

    private final Scanner scan;

    public HumanMovementStrategy(){
        this.scan = new Scanner(System.in);
    }

    @Override
    public Position move(Position currentPosition) {

        System.out.println("Enter your move: W:up, S:down, A:left, D:right");
        String move = scan.nextLine().toUpperCase();

        int row = currentPosition.getRow();
        int column = currentPosition.getColumn();
        Position newPos = new Position(-1, -1); //posizione random irragiungibile per il caso di input errato

        switch (move){
            //TODO convert position to enum
            case "W" :  newPos = Directions.UP.move(new Position(row, column));
                        break;
            case "S" :  newPos = Directions.DOWN.move(new Position(row, column));
                        break;
            case "D" :  newPos = Directions.RIGHT.move(new Position(row, column));
                        break;
            case "A" :  newPos = Directions.LEFT.move(new Position(row, column));
                        break;
            default  :  break;
        }
        return newPos;
    }
}
