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

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BotMovementStrategyTest {

    @Test
    public void TestBotMovementStrategyMove(){
        Track track = new Track(2, 3);
        BotMovementStrategy botStrategy = new BotMovementStrategy(track);

        Position startPosition = new Position(0,0);
        Position newPosition = botStrategy.move(startPosition);

        assertNotNull(newPosition);
        assertTrue(newPosition.getRow() >= 0 && newPosition.getColumn() >= 0);
    }

    @Test
    public void TestCheckValidMove(){
        Track track = new Track(5, 6);
        BotMovementStrategy botStrategy = new BotMovementStrategy(track);

        track.getTrack()[1][1] = '.';
        Position validMove = new Position(1,1);
        assertTrue(botStrategy.checkValidMove(validMove));

        track.getTrack()[3][3] = 'B';
        Position validMoveBotPresent = new Position(3,3);
        assertFalse(botStrategy.checkValidMove(validMoveBotPresent));

        Position invalidMove = new Position(10,1);
        assertFalse(botStrategy.checkValidMove(invalidMove));
    }


}