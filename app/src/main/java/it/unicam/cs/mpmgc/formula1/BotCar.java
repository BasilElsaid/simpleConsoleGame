package it.unicam.cs.mpmgc.formula1;

public class BotCar implements iRacer {

    private final String name;
    private final Position currentPosition;

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

    public void calculateNextMove(){
        int x = currentPosition.getX();
        int y = currentPosition.getY();
        Position nextMove = new Position(x, y+1);
        UpdatePosition(nextMove);
    }


}
