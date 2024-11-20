package it.unicam.cs.mpmgc.formula1;

public interface iRacer {

    /**
     *
     * @return nome del veicolo
     */
    String getName();

    /**
     *
     * @return posizione attuale del veicolo
     */
    Position getCurrentPosition();

    /**
     * aggiornare la posizione
     * @param newPosition nuova posizione
     */
    void UpdatePosition(Position newPosition);
}
