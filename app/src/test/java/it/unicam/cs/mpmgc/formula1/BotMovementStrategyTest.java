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

import it.unicam.cs.mpmgc.formula1.players.BotMovementStrategy;
import it.unicam.cs.mpmgc.formula1.players.Car;
import it.unicam.cs.mpmgc.formula1.players.Directions;
import it.unicam.cs.mpmgc.formula1.players.iCar;
import it.unicam.cs.mpmgc.formula1.track.Track;
import it.unicam.cs.mpmgc.formula1.utils.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BotMovementStrategyTest {

    Track track;
    BotMovementStrategy botStrategy;
    iCar BotCar;

    @BeforeEach
    public void TrackSetUp(){
        track = new Track(5,6);
        botStrategy = new BotMovementStrategy(track);
        BotCar = new Car("Bot1", botStrategy);
    }

    @Test
    public void TestCheckValidMove(){
        track.getTrack()[1][1] = '.';
        Position validMove = new Position(1,1);
        assertTrue(track.checkValidMove(validMove));
    }

    @Test
    public void TestInvalidMove(){
        Position invalidMove = new Position(10,1);
        assertFalse(track.checkValidMove(invalidMove));
    }

    @Test
    public void TestInvalidMoveForObstacle(){
        track.getTrack()[3][3] = 'B';
        Position validMoveButAnotherBotPresent = new Position(3,3);
        assertFalse(track.checkValidMove(validMoveButAnotherBotPresent));
    }

    @Test
    public void TestDirectionMovement(){
        Position startingPosition = new Position(2, 2);

        Position rightMovement = Directions.RIGHT.move(startingPosition, 2);
        assertEquals(new Position(2, 4), rightMovement);

        Position leftMovement = Directions.LEFT.move(startingPosition, 1);
        assertEquals(new Position(2, 1), leftMovement);

        Position upMovement = Directions.UP.move(startingPosition, 1);
        assertEquals(new Position(1, 2), upMovement);

        Position downMovement = Directions.DOWN.move(startingPosition, 2);
        assertEquals(new Position(4, 2), downMovement);
    }

    @Test
    public void TestBotInitialDefaultDirection(){
        assertEquals(Directions.RIGHT, botStrategy.getNextDirection());
    }

    @Test
    public void TestBotChangeDirectionOnObstacle(){
        // move() checks the car updatePosition() method
        track.getTrack()[0][4] = '#';                       // obstacle with Directions.RIGHT -> go Down
        botStrategy.move(new Position(0,4));
        assertEquals(Directions.DOWN, botStrategy.getNextDirection());

        track.getTrack()[4][4] = '#';                       // obstacle with Directions.DOWN -> go Left
        botStrategy.move(new Position(4,4));
        assertEquals(Directions.LEFT, botStrategy.getNextDirection());

        track.getTrack()[4][0] = '#';                       // obstacle with Directions.LEFT -> go Up
        botStrategy.move(new Position(4,0));
        assertEquals(Directions.UP, botStrategy.getNextDirection());
    }

}