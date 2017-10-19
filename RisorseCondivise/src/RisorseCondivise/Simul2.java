package RisorseCondivise;

import java.util.concurrent.TimeUnit;
/**
 *
 * @author federico.scaggiante
 */

public class Simul2 {
    public static void main(String[] args) {
        Risorsa r1 = new Risorsa("risorsa1");
        Risorsa r2 = new Risorsa("risorsa2");
        Thread t1 = new Thread(new Task(r1,r2));
        Thread t2 = new Thread(new Task(r1,r2));
        t1.setName("thread1");
        t2.setName("thread2");
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
