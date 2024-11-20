package it.unicam.cs.mpmgc.formula1;

public interface iGamePlay {

    /**
     * starts the game
     * @param bot1 the first Bot car that will play
     * @param bot2 the second Bot Car that will play
     * @param car1 the Human Car "User" that will play the game
     * @param track the track of the game
     */
    void startGame(BotCar bot1, BotCar bot2, HumanCar car1, SimpleTrack track);

    /**
     * updates the state of the game
     * @param track the track to be updated
     */
    void updateGame(SimpleTrack track);

    /**
     * ends the game
     */
    void endGame();

    /**
     * gives the name of the winner
     * @param track the track where the players race
     */
    void checkWinner(SimpleTrack track);
}
