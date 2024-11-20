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
     * @param bot1 the first Bot car that will play
     * @param bot2 the second Bot Car that will play
     * @param car1 the Human Car "User" that will play the game
     * @param track the track of the game
     */
    public void startGame(BotCar bot1, BotCar bot2, HumanCar car1, SimpleTrack track);

    /**
     * updates the state of the game
     * @param track the track to be updated
     */
    public void updateGame(SimpleTrack track);

    /**
     * ends the game
     */
    public void endGame();

    /**
     * gives the name of the winner
     * @param track the track where the players race
     */
    public void checkWinner(SimpleTrack track);
}
