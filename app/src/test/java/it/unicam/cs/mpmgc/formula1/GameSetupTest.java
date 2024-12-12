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

class GameSetupTest {

    @Test
    public void TestGameSetupTrack(){
        GameSetup setup = new GameSetup();
        setup.setupGame();
        Track track = setup.getTrack();

        assertNotNull(track);
        assertEquals(16, track.getRows());
        assertEquals(20, track.getColumns());
    }

    @Test
    public void TestGameSetupPlayers(){
        GameSetup setup = new GameSetup();
        List<String[]> playerData = new ArrayList<>();
        playerData.add(new String[]{"Bot", "BotPlayer"});
        playerData.add(new String[]{"Human", "HumanPlayer"});
        setup.setupPlayers(playerData);
        List<iCar> players = setup.getPlayers();

        assertEquals(2, players.size());
        assertEquals("BotPlayer", players.get(0).getName());
        assertEquals("HumanPlayer", players.get(1).getName());
    }

}