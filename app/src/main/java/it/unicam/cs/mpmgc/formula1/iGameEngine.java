package it.unicam.cs.mpmgc.formula1;

import java.util.List;

public interface iGameEngine {

    /**
     * adds a bot to the players list,
     * and gives it a starting position on the starting line.
     * @param bot an instance of a BotCar class
     */
    public void addBot(BotCar bot);

    /**
     * adds a humanPlayer to the players list,
     * and gives it a starting position on the starting line.
     * @param player an instance of a HumanCar class
     */
    public void addPlayer(HumanCar player);

    /**
     * starts the game
     */
    public void startGame();

    /**
     * ends the game
     */
    public void endGame();

    /**
     * gives the name of the winner
     * @return the winner's name
     */
    public String findWinnerName();
}
