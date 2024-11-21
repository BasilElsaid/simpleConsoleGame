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

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SimpleTrack implements iTrack{

    private int rows;
    private int columns;
    private char[][] track;
    private List<String> trackLines = new ArrayList<>();

    public SimpleTrack(){
        InputStream gameTrack =
                getClass().getClassLoader().getResourceAsStream("trackFormat.txt");
        Scanner scan = new Scanner(gameTrack);
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            if (line.isEmpty() == false) {
                trackLines.add(line);
            }
        }
        scan.close();
        this.rows = trackLines.size();
        this.columns = trackLines.get(0).length();
        track = new char[this.rows][this.columns];
    }

    @Override
    public void createTrack() {
        for (int row = 0; row < rows ; row++){
            String line = trackLines.get(row);
            for (int column = 0; column < columns; column++ ){
                if (column < line.length()){
                    track[row][column] = line.charAt(column);
                }
                System.out.println();
            }
        }
    }

    @Override
    public void displayTrack(){
        for (char[] chars : track) {
            for (char aChar : chars) {
                System.out.print(aChar);
            }
            System.out.println();
        }
    }

    @Override
    public void placePlayers(List<iRacer> players){
        for (iRacer player : players){
            if (player instanceof BotCar){
                track[player.getCurrentPosition().getRow()]
                        [player.getCurrentPosition().getColumn()] = 'B';
            }
            else{
                track[player.getCurrentPosition().getRow()]
                        [player.getCurrentPosition().getColumn()] = 'P';
            }
        }
    }

    @Override
    public void ResetCurrentPositionSymbol(List<iRacer> players) {
        for (iRacer player : players){
            track[player.getCurrentPosition().getRow()]
                    [player.getCurrentPosition().getColumn()] = '.';
        }
    }

    @Override
    public String crossedFinalLine(List<iRacer> players) {
        for (iRacer player : players){
            if (player.getCurrentPosition().getColumn() == columns-2){
                return player.getName();
            }
        }
        return "Undefined";
    }
}
