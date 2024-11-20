package it.unicam.cs.mpmgc.formula1;

import java.util.Scanner;

public class GamePlay extends GameSetup
        implements iGamePlay {

    private boolean gameFinished = false;
    private String winnerName = "";


    public GamePlay(){
    }

    @Override
    public void startGame(BotCar botCar1, BotCar botCar2, HumanCar car1, SimpleTrack track){
        while (gameFinished == false) {
            track.ResetCurrentPositionSymbol(getPlayersPositions());
            System.out.println("write 'a' to accelerate, 'd' to decelerate, 'q' to exit");
            Scanner scan = new Scanner(System.in);

            switch (scan.next()) {
                case "a" -> car1.accelerate();
                case "d" -> car1.decelerate();
                case "q" -> endGame();
                default -> System.out.println("Wrong Input!");
            }
            botCar1.calculateNextMove();
            botCar2.calculateNextMove();
            updateGame(track);
        }
    }

    @Override
    public void updateGame(SimpleTrack track) {
        track.placePlayers(getPlayersPositions());
        track.displayTrack();
        checkWinner(track);
    }

    @Override
    public void endGame(){
        this.gameFinished = true;
        if (winnerName == null){
            System.out.println("You quit the Game");
        }
        else {
            System.out.println("The winner is : " + winnerName);
        }
    }

    @Override
    public void checkWinner(SimpleTrack track){
        winnerName = track.crossedFinalLine(super.getPlayersPositions());
        if (winnerName != null){
            endGame();
        }
    }

}
