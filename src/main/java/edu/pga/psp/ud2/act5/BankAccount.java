package edu.pga.psp.ud2.act5;

public class BankAccount {
    private int balance;


    public BankAccount(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }


    public synchronized boolean withdraw(String clienteNombre, int saldo)  {
        System.out.println(clienteNombre + " va a retirar " + saldo);
        if (saldo > this.balance){
            System.out.println(clienteNombre + " no puede retirar: saldo insuficiente.");
            return false;
        } try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return false;
        }
        this.balance -= saldo;
        System.out.println(clienteNombre + " completó la retirada. Saldo restante: " + getBalance());
        return true;
    }

}
