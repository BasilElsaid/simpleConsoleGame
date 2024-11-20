package it.unicam.cs.mpmgc.formula1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BotCarTest {

    @Test
    void getNameTest() {
        BotCar car1 = new BotCar("3");
        assertEquals("3", car1.getName());
    }

    @Test
    void getCurrentPositionAndUpdatePositionTests() {
        BotCar car1 = new BotCar("3");
        car1.UpdatePosition(new Position(4,5));
        assertEquals(4, car1.getCurrentPosition().getX());
        assertEquals(5, car1.getCurrentPosition().getY());
    }

    @Test
    void calculateNextMove() {
    }
}