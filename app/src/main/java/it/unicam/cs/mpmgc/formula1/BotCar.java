package it.unicam.cs.mpmgc.formula1;

public class BotCar implements iRacer {

    private String name;
    private Position currentPosition;

    public BotCar(String name){
        this.name = name;
        this.currentPosition = new Position(0,0);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Position getCurrentPosition() {
        return currentPosition;
    }

    @Override
    public void UpdatePosition(Position newPosition) {
        currentPosition.setX(newPosition.getX());
        currentPosition.setY(newPosition.getY());
    }

    public Position calculateNextMove(Position currentPosition){
        return null;
        //TODO
    }


}
