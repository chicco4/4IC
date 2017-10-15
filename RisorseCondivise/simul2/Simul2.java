package simul2;

import static simul2.Risorsa.semaphore;

/**
 *
 * @author matteo
 */
public class Simul2 {

    public static void main(String[] args) {
        System.out.println("Total available Semaphore permits : " + semaphore.availablePermits());
        Task t2 = new Task("B");
        Task t1 = new Task("A");
        
        t1.start();
        t2.start();
    }

}
