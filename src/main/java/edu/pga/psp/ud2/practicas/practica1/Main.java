package edu.pga.psp.ud2.practicas.practica1;


public class Main {

    public static void main(String[] args) {

            RailwayControl railwayControl = new RailwayControl();

            Thread t1 = new Thread(new Train("Tren A1", "A->B", railwayControl));
            Thread t2 = new Thread(new Train("Tren A2", "A->B", railwayControl));
            Thread t3 = new Thread(new Train("Tren A3", "A->B", railwayControl));
            Thread t4 = new Thread(new Train("Tren A4", "A->B", railwayControl));

            Thread t5 = new Thread(new Train("Tren B1", "B->A", railwayControl));
            Thread t6 = new Thread(new Train("Tren B2", "B->A", railwayControl));


        try {
            t1.start();
            t2.start();
            t3.start();
            t4.start();
            t5.start();
            t6.start();

            t1.join();
            t2.join();
            t3.join();
            t4.join();
            t5.join();
            t6.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
