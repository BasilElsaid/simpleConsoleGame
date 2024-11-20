package it.unicam.cs.mpmgc.formula1;

import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

public class SimpleTrack implements iTrack{

    private int rows = 8;
    private int columns = 18;
    private char[][] track = new char[this.rows][this.columns];

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
    public String acrossedFinalLine(List<iRacer> players) {
        for (iRacer player : players){
            if (player.getCurrentPosition().getY() == columns-2){
                return player.getName();
            }
        }
        return null;
    }
}
