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

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileIO {

    public FileIO(){};

    public List<String> readTrack(){
        try {
            List<String> trackLines;
            Path filePath = Path.of(getClass().getClassLoader().getResource("newTrack.txt").toURI());
            trackLines = Files.readAllLines(filePath);
            return trackLines;
        } catch (Exception e){
            throw new RuntimeException("Error reading the file", e);
        }
    }

    public int[] loadTrack(List<String> trackLines){
        int rows = trackLines.size();
        int columns = trackLines.get(0).length();
        return new int[]{rows, columns};
    }

    public List<String> readPlayers(){
        try {
            Path filePath = Path.of(getClass().getClassLoader().getResource("playersFile.txt").toURI());
            return Files.readAllLines(filePath);
        } catch (Exception e){
            throw new RuntimeException("Error reading the file", e);
        }
    }

    public List<String[]> loadPlayers(List<String> playerLines){
        List<String[]> playerData = new ArrayList<>();
        for (String line : playerLines) {
            String[] parts = line.split(",");
            if (parts.length != 2) {
                System.out.println("Invalid entry in file" + line);
                continue;
            }
            String type = parts[0].trim();
            String name = parts[1].trim();
            playerData.add(new String[]{type, name});
        }
        return playerData;
    }

}
