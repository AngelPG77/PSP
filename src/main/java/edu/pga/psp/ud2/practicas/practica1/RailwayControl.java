package edu.pga.psp.ud2.practicas.practica1;

public class RailwayControl {

    private boolean isRailwayFree = true;
    private String currentDirection = null;
    private int trainCount = 0;
    private int trainsInARow = 0;
    private final int MAX_TRAINS_IN_A_ROW = 3;

    public synchronized void enterRailway(String trainName, String direction) throws InterruptedException {

        System.out.println(trainName + " intenta entrar a la vía " + direction);

        while (!isRailwayFree && !currentDirection.equals(direction) ||
                (currentDirection != null && !direction.equals(direction) ||
                        (trainsInARow >= MAX_TRAINS_IN_A_ROW && currentDirection.equals(direction)))) {

            if (direction != null && !currentDirection.equals(direction)) {
                System.out.println("Vía ocupada. " + trainName + " debe esperar: vía ocupada por trenes " + currentDirection);
            }
            if (direction!= null && currentDirection.equals(direction)){
                System.out.println(trainName+ " debe esperar: Alcanzado el máximo de trenes en la misma dirección " + currentDirection);
            }
            wait();
        }

        isRailwayFree = false;
        currentDirection = direction;
        trainCount++;
        trainsInARow++;

        System.out.println(trainName + " entra en la vía " + direction);
    }

    public synchronized void exitRailway(String trainName) {
        trainCount--;
        System.out.println(trainName + " sale de la vía " + currentDirection);

        if (trainCount == 0){
            System.out.println("Vía libre.");
            isRailwayFree = true;
            currentDirection = null;
        }
        if (trainsInARow >= MAX_TRAINS_IN_A_ROW){
            trainsInARow = 0;
        }
        notifyAll();
    }


}
