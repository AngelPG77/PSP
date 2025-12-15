package edu.pga.psp.ud2.act6;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        CarWash cw = new CarWash();

        Thread t1 = new Thread(new Car(cw, "Coche 1"));
        Thread t2 = new Thread(new Car(cw, "Coche 2"));
        Thread t3 = new Thread(new Car(cw, "Coche 3"));

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
