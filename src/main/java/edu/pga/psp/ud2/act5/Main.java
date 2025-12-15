package edu.pga.psp.ud2.act5;

public class Main {
    public static void main(String[] args) {
        BankAccount cuenta = new BankAccount(150);


        Thread client1 = new Thread(new Client( cuenta, 2, 50, "Cliente 1"));
        Thread client2 = new Thread(new Client( cuenta, 1, 50, "Cliente 2"));
        Thread client3 = new Thread(new Client( cuenta, 1, 150, "Cliente 3"));

        client1.start();
        client2.start();
        client3.start();

        try {
            client1.join();
            client2.join();
            client3.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

    }
}
