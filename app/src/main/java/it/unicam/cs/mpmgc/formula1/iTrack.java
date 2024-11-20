package it.unicam.cs.mpmgc.formula1;

import java.util.List;

public interface iTrack {

    /**
     * creates the track from a reading text file.
     */
    void createTrack();

    /**
     * displays the track in the console, with eventual updates
     */
    void displayTrack();

    /**
     * it puts a letter on the start line of the track to indicate the racer:
     * "P" for HumanPlayer
     * "B" for BotPlayer
     * @param players a list the contains all the players' names and their positions.
     */
    void placePlayers(List<iRacer> players);

    /**
     * remove the car symbol from the current position before moving to a new one
     * @param players a list the contains all the players' names and their positions before moving
     */
    void ResetCurrentPositionSymbol(List<iRacer> players);

    /**
     * checks if a player acrossed the final line
     * @param players a list of the racers
     * @return name of th winner
     */
    String crossedFinalLine(List<iRacer> players);
}
