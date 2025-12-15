package edu.pga.psp.ud2.act5;

public class Client implements Runnable{

    private BankAccount cuenta;
    private int numRetiradas;
    private int cantidad;
    private String name;


    public Client(BankAccount cuenta, int numRetiradas, int cantidad, String name) {
        this.cuenta = cuenta;
        this.numRetiradas = numRetiradas;
        this.cantidad = cantidad;
        this.name = name;
    }

    @Override
    public void run() {

        for (int i = 0; i < numRetiradas; i++) {
            cuenta.withdraw(name, cantidad);
        }

    }
}
