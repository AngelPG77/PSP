package edu.pga.psp.ud2.practicas.practica1;

public class Train implements Runnable {

    private String trainName;
    private String direction;
    private RailwayControl railwayControl;

    public Train(String trainName, String direction, RailwayControl railwayControl) {
        this.trainName = trainName;
        this.direction = direction;
        this.railwayControl = railwayControl;
    }

    @Override
    public void run() {
        try {
            railwayControl.enterRailway(this.trainName, this.direction);
            Thread.sleep((long) (Math.random() * 3000) + 1000);
            railwayControl.exitRailway(this.trainName);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
