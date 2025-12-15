package edu.pga.psp.ud2.act7;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        KitchenQueue kq = new KitchenQueue(new LinkedList<>(), 3);

        Thread chef = new Thread(new Chef(kq, 5));
        Thread waiter = new Thread(new Waiter(kq));

        chef.start();
        waiter.start();

        try {
            chef.join();
            waiter.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
