package edu.pga.psp.ud2.act6;

public class CarWash {
    private boolean occupied = false;


    public CarWash() {
    }

    public synchronized void enter(String carName) throws InterruptedException {
        while (occupied){
            System.out.println(carName + " espera su turno");
            wait();
        }
        this.occupied = true;
        System.out.println(carName + " entra al lavado");
        Thread.sleep(2000);
    }

    public synchronized void exit(String carName) throws InterruptedException {
        this.occupied = false;
        System.out.println(carName + " sale del lavado");
        notifyAll();
    }
}
