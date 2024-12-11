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

    List<String> trackLines;
    List<String> playerLines;

    public FileIO(){
        trackLines = new ArrayList<>();
        playerLines = new ArrayList<>();
    }

    public void readAndParseFile(){
        try {
            Path filePath = Path.of(getClass().getClassLoader().getResource("TrackAndPlayers.txt").toURI());
            List<String> fileLines = Files.readAllLines(filePath);
            parseFile(fileLines);
        } catch (Exception e){
            throw new RuntimeException("Error reading the file", e);
        }
    }

    public void parseFile(List<String> fileLines){
        trackLines.clear();
        playerLines.clear();

        for (String line : fileLines){
            if(line.contains("#") || line.contains(".")){
                trackLines.add(line);
            }
            else {
                playerLines.add(line);
            }
        }
    }

    public int[] loadTrack(){
        if (trackLines.isEmpty()){
            throw new IllegalStateException("Track Data is not loaded.");
        }
        int rows = trackLines.size();
        int columns = trackLines.get(0).length();
        return new int[]{rows, columns};
    }

    public List<String> getTrackLines(){
        return trackLines;
    }

    public List<String[]> loadPlayers(){
        List<String[]> playerData = new ArrayList<>();
        for (String line : playerLines) {
            String[] parts = line.split(",");
            if (parts.length != 2) {
                System.err.println("Invalid player data format: " + line);
                continue;
            }
            String type = parts[0].trim();
            String name = parts[1].trim();
            playerData.add(new String[]{type, name});
        }
        return playerData;
    }

}
