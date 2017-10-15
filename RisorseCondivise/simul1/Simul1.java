package simul1;

import static simul1.Risorsa.semaphore;

/**
 *
 * @author matteo
 */
public class Simul1 {
    public static void main(String[] args) {

        System.out.println("Total available Semaphore permits : " + semaphore.availablePermits());

        Task t1 = new Task("A");
        t1.start();

        Task t2 = new Task("B");
        t2.start();

    }
}
