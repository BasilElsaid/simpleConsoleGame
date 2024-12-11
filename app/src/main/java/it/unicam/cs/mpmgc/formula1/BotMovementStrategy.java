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

    private final Random random;
    private Directions lastDirection;
    private int speed;

    public BotMovementStrategy(){
        this.random = new Random();
        this.lastDirection = null;
        this.speed = 1;
    }

    @Override
    public Position move(Position currentPosition) {
        Directions[] directions = Directions.values();
        int randomIndex = random.nextInt(directions.length);
        Directions currentDirection = directions[randomIndex];

        updateSpeed(currentDirection);
        return currentDirection.move(currentPosition, speed);
    }

    @Override
    public void updateSpeed(Directions currentDirection) {
        if (lastDirection != null && lastDirection == currentDirection){
            if (speed < 4){
                speed++;
            }
        } else{
            speed = 1;
        }
        lastDirection = currentDirection;
    }

}
