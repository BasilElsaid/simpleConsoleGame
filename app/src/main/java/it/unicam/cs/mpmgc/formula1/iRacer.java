package it.unicam.cs.mpmgc.formula1;

public interface iRacer {

    /**
     *
     * @return nome del veicolo
     */
    public String getName();

    /**
     *
     * @return posizione attuale del veicolo
     */
    public Position getCurrentPosition();

    /**
     * aggiornare la posizione
     * @param newPosition nuova posizione
     */
    public void UpdatePosition(Position newPosition);
}
