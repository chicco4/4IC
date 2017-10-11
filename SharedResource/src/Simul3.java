package SharedResource;

import java.util.concurrent.TimeUnit;

public class Simul3 {

    public static void main(String[] args) {
        Resource r1 = new Resource("r1");
        Resource r2 = new Resource("r2");
        Thread t1 = new Thread(new Task(r1, r2));
        Thread t2 = new Thread(new Task(r2, r1));
        t1.setName("t1");
        t2.setName("t2");
        t1.start();
        t2.start();
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
        }
        t1.interrupt();
        t2.interrupt();
    }
}
