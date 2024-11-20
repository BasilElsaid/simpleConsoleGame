package it.unicam.cs.mpmgc.formula1;

import java.util.List;

public interface iTrack {

    /**
     * creates the track from a reading text file.
     */
    public void createTrack();

    /**
     * displays the track in the console, with eventual updates
     */
    public void displayTrack();

    /**
     * it puts a letter on the start line of the track to indicate the racer:
     * "P" for HumanPlayer
     * "B" for BotPlayer
     * @param players a list the contains all the players' names and starting positions.
     */
    public void putPlayerAtStartLine(List<iRacer> players);


}
