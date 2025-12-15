package edu.pga.psp.ud2.act7;

public class Waiter implements Runnable {

    KitchenQueue kq;


    public Waiter(KitchenQueue kq) {
        this.kq = kq;
    }

    @Override
    public void run() {

        while (true){
            try {
                kq.takeDish();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }
}
