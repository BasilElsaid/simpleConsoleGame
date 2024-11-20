package it.unicam.cs.mpmgc.formula1;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class GameEngine implements iGameEngine{

    private SimpleTrack track;
    private List<iRacer> players = new LinkedList<>();
    private int playerIndex = 1;
    private boolean gameFinished = false;
    private String winnerName = "";


    public GameEngine(){
        //TODO
    }

    @Override
    public void addBot(BotCar bot){
        bot.UpdatePosition(new Position(playerIndex, 1));
        players.add(bot);
        playerIndex++;
    }

    @Override
    public void addPlayer(HumanCar player){
        player.UpdatePosition(new Position(playerIndex, 1));
        players.add(player);
        playerIndex++;
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
        gameFinished = true;
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
        System.out.println("The winner is : " + winnerName);
    }

    @Override
    public void checkWinner(SimpleTrack track){
        winnerName = track.acrossedFinalLine(players);
        if (winnerName != null){
            endGame();
        }
    }

    public List<iRacer> getPlayersPositions(){
        return players;
    }


}
