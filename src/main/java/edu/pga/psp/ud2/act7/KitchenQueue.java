package edu.pga.psp.ud2.act7;

import java.util.Queue;

public class KitchenQueue {
    private Queue<String> queue;
    private int capacity;


    public KitchenQueue(Queue<String> queue, int capacity) {
        this.queue = queue;
        this.capacity = capacity;
    }


    public Queue<String> getQueue() {
        return queue;
    }

    public synchronized void putDish(String dish) throws InterruptedException {
        while (queue.size() >= capacity) {
            wait();
        }
        queue.add(dish);
        System.out.println("Cocinero pone " + dish);
        notifyAll();
    }

    public synchronized void takeDish() throws InterruptedException {
        while (queue.isEmpty()){
            wait();
        }
        while (!queue.isEmpty()) {
            String dish = queue.poll();
            System.out.println("Camarero recoge " + dish);
        }
        notifyAll();
    }
}
