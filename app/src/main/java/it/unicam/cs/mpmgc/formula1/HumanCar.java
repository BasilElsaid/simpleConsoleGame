package it.unicam.cs.mpmgc.formula1;

import java.util.Scanner;

public class HumanCar implements iRacer {

    private String name;
    private Position currentPosition;

    public HumanCar(String name){
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

    public void accelerate(){
        //TODO
    }

    public void decelerate(){
        //TODO
    }
}
