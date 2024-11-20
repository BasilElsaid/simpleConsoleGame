package it.unicam.cs.mpmgc.formula1;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class GameEngine implements iGameEngine{

    private Track track;
    private List<iRacer> players = new LinkedList<>();
    private int playerIndex = 1;
    private boolean gameFinished = false;


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
    public void startGame(){
        //TODO
        while (gameFinished == false) {
            System.out.println("write 'a' to accelerate, 'd' to decelerate");
            Scanner scan = new Scanner(System.in);
            if (scan.next().equals('w')){
                //TODO accelerate
            } else if (scan.next().equals('d')) {
                //TODO decelerate
            }
            else {
                System.out.println("Wrong Input!");
            }
        }
        gameFinished = true;
    }

    @Override
    public void endGame(){
        //TODO
    }

    @Override
    public String findWinnerName(){
        //TODO
        return null;
    }

    public List<iRacer> placePlayersOnTrack(){
        return players;
    }


}
