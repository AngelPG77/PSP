package edu.pga.psp.ud2.act8;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class KitchenQueue {
    private Queue<String> queue;
    private int capacity;

    private Semaphore huecosLibres;
    private Semaphore platosListos;
    private Semaphore mutex;


    public KitchenQueue(Queue<String> queue, int capacity) {
        this.queue = queue;
        this.capacity = capacity;
        this.huecosLibres = new Semaphore(capacity);
        this.mutex = new Semaphore(1);
        this.platosListos = new Semaphore(0);
    }


    public Queue<String> getQueue() {
        return queue;
    }

    public void putDish(String dish) throws InterruptedException {
        huecosLibres.acquire();
        mutex.acquire();
        queue.add(dish);
        mutex.release();
        System.out.println("Chef añade un plato");
        platosListos.release();
    }

    public void takeDish() throws InterruptedException {
        platosListos.acquire();
        mutex.acquire();
        queue.poll();
        mutex.release();
        System.out.println("Camarero se lleva un plato");
        huecosLibres.release();
    }
}
