package test;

import java.util.concurrent.TimeUnit;

/**
 *
 * @author giacomo.ravagnan
 */
public class test2 {
    public static void main(String[] args) {
        Risorsa risorsa1 = new Risorsa("risorsa1");
        Risorsa risorsa2 = new Risorsa("risorsa2");
        Thread t1 = new Thread(new Task(risorsa1, risorsa2));
        Thread t2 = new Thread(new Task(risorsa1, risorsa2));
        t1.start();
        t2.start();
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.interrupt();
        t2.interrupt();
    }
    }
    
