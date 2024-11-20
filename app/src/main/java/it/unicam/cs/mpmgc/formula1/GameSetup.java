package it.unicam.cs.mpmgc.formula1;

import java.util.LinkedList;
import java.util.List;

public class GameSetup implements iGameSetup{

    private final List<iRacer> players = new LinkedList<>();
    private int playerIndex = 1;

    public GameSetup() {

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
    public List<iRacer> getPlayersPositions(){
        return players;
    }

}
