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

public class BotMovementStrategy implements iMovementStrategy{

    private Directions currentDirection;
    private Directions lastDirection;
    private int speed;
    private Track track;

    public BotMovementStrategy(Track track){
        this.currentDirection = Directions.RIGHT;
        this.speed = 1;
        this.track = track;
    }

    @Override
    public Position move(Position currentPosition) {
        Position newPos = currentDirection.move(currentPosition, speed);
        if (!track.checkValidMove(newPos)){
            switch (currentDirection){
                case RIGHT -> currentDirection = Directions.DOWN;
                case DOWN -> currentDirection = Directions.LEFT;
                case LEFT -> currentDirection = Directions.UP;
                case UP -> currentDirection = Directions.RIGHT;
            }
        }
        updateSpeed(currentDirection);
        return currentDirection.move(currentPosition, speed);
    }

    @Override
    public void updateSpeed(Directions currentDirection) {
        if (lastDirection != null && lastDirection == currentDirection){
            if (speed < 2){
                speed++;
            }
        } else{
            speed = 1;
        }
        lastDirection = currentDirection;
    }

}