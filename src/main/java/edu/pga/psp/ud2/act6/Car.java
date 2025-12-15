package edu.pga.psp.ud2.act6;

public class Car implements Runnable{

    private CarWash cw;
    private String carName;

    public Car(CarWash cw, String carName) {
        this.cw = cw;
        this.carName = carName;
    }


    @Override
    public void run() {

       try {
           cw.enter(this.carName);
           Thread.sleep(1);
           cw.exit(this.carName);
       } catch (InterruptedException e) {
           throw new RuntimeException(e);
       }
    }

}
