package edu.pga.psp.ud2.act7;

public class Chef implements Runnable {
    KitchenQueue kq;
    int dishQuantity;

    public Chef(KitchenQueue kq, int dishQuantity) {
        this.kq = kq;
        this.dishQuantity = dishQuantity;
    }

    @Override
    public void run() {

        for (int i = 0; i < dishQuantity; i++) {
            try {
                kq.putDish("Plato " + (i+1));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
