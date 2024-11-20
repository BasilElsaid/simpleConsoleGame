package it.unicam.cs.mpmgc.formula1;

import java.util.List;

public interface iGameSetup {

    /**
     * adds a bot to the players list,
     * and gives it a starting position on the starting line.
     * @param bot an instance of a BotCar class
     */
    void addBot(BotCar bot);

    /**
     * adds a humanPlayer to the players list,
     * and gives it a starting position on the starting line.
     * @param player an instance of a HumanCar class
     */
    void addPlayer(HumanCar player);

    /**
     * getter of players positions
     * @return list of players' names and positions
     */
    List<iRacer> getPlayersPositions();
}
