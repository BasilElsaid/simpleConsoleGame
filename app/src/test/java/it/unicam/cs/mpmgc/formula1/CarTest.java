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

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    public void TestUpdatePosition(){
        Track track = new Track(4, 8);
        Car car = new Car("TestCar", new BotMovementStrategy(track));
        Position newPos = new Position(2,2);
        car.UpdatePosition(newPos);
        assertEquals(newPos, car.getCurrentPosition());
    }

    @Test
    public void TestMove(){
        List<String> trackLines = new ArrayList<>();
        trackLines.add("########");
        trackLines.add("#......#");
        trackLines.add("#....__#");
        trackLines.add("########");
        Track track = new Track(4, 8);
        track.createTrack(trackLines);

        Car car = new Car("TestCar", new BotMovementStrategy(track));
        Position initialPos = new Position(1,1);
        car.UpdatePosition(initialPos);

        car.move();

        assertNotEquals(initialPos, car.getCurrentPosition());
    }

}