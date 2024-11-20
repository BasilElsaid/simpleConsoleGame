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
import java.util.List;
import java.util.Scanner;

public class SimpleTrack implements iTrack{

    private final int rows = 8;
    private final int columns = 18;
    private final char[][] track = new char[this.rows][this.columns];

    public SimpleTrack(){
    }

    @Override
    public void createTrack() {
        InputStream gameTrack =
                getClass().getClassLoader().getResourceAsStream("trackFormat.txt");
        Scanner scan = new Scanner(gameTrack);

        for (int x = 0; x < rows ; x++){
            String line = scan.nextLine();
            for (int y = 0; y < columns; y++ ){
                if (y < line.length()){
                    track[x][y] = line.charAt(y);
                }
                System.out.println();
            }
        }
        scan.close();
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
        //TODO
        for (iRacer player : players){
            if (player instanceof BotCar){
                track[player.getCurrentPosition().getX()]
                        [player.getCurrentPosition().getY()] = 'B';
            }
            else{
                track[player.getCurrentPosition().getX()]
                        [player.getCurrentPosition().getY()] = 'P';
            }
        }
    }

    @Override
    public void ResetCurrentPositionSymbol(List<iRacer> players) {
        for (iRacer player : players){
            track[player.getCurrentPosition().getX()]
                    [player.getCurrentPosition().getY()] = '.';
        }
    }

    @Override
    public String crossedFinalLine(List<iRacer> players) {
        for (iRacer player : players){
            if (player.getCurrentPosition().getY() == columns-2){
                return player.getName();
            }
        }
        return null;
    }
}
