package simul3;

import static simul3.Risorsa.semaphore;

/**
 *
 * @author matteo
 */
public class Simul3 {
    public static void main(String[] args) {
        
        System.out.println("Total available Semaphore permits : " + semaphore.availablePermits());
        Task t2 = new Task("B",0,1);
        Task t1 = new Task("A",1,0);
        
        t1.start();
        t2.start();
    }
    
}
