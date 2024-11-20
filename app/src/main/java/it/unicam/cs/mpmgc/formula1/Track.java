package it.unicam.cs.mpmgc.formula1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class Track implements iTrack{

    private int rows = 8;
    private int columns = 18;
    private char[][] track = new char[rows][columns];

    File gameTrack = new File("/Users/basil/Documents/unicam/secondoAnno/Metodologie di Programmazione/progetto/app/src/main/resources/test.txt/");
    Scanner scan;
    {
        try {
            scan = new Scanner(gameTrack);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Track(int rows, int columns){
        this.rows = rows;
        this.columns = columns;
    }

    @Override
    public void createTrack() {
        //TODO
        for (int x = 0; x < rows ; x++){
            String line = scan.nextLine();
            for (int y = 0; y < columns; y++ ){
                if (y < line.length()){
                    track[x][y] = line.charAt(y);
                }
                System.out.println();
            }
        }

        //SAMPLE TRACK
        /*
        ##################
        #................#
        #................#
        #................#
        #................#
        #................#
        #................#
        ##################
        */

    }

    @Override
    public void displayTrack(){
        for (int x = 0; x < track.length ; x++){
            for (int y = 0; y < track[x].length; y++ ){
                System.out.print(track[x][y]);
            }
            System.out.println();
        }
    }

    @Override
    public void putPlayerAtStartLine(List<iRacer> players){
        //TODO
        for (iRacer player : players){
            if (player instanceof BotCar){
                track[player.getCurrentPosition().getX()][player.getCurrentPosition().getY()] = 'B';
            }
            else{
                track[player.getCurrentPosition().getX()][player.getCurrentPosition().getY()] = 'P';
            }
        }
    }
}
