package RisorseCondivise;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
/**
 *
 * @author federico.scaggiante
 */

public class Task extends Thread {
    private Semaphore tlight;
    private Risorsa r1;
    private Risorsa r2;
    public Task(Risorsa r1, Risorsa r2) {
        this.r1 = r1;
        this.r2 = r2;
    }
    public Task(Risorsa r1) {
        this(r1, null);
    }
    public void run() {
        while(true) {
            try {
                TimeUnit.SECONDS.sleep(new Random().nextInt(2));
                if (r2 == null) {
                    r1.semaforo.acquire();
                    System.out.println(this.getName() + " sta usando " + r1.getName());
                    TimeUnit.SECONDS.sleep(new Random().nextInt(3));
                    r1.semaforo.release();
                    System.out.println(this.getName() + " ha rilasciato " + r1.getName());
                }
                else{
                    r1.semaforo.acquire();
                    r2.semaforo.acquire();
                    System.out.println(this.getName() + " sta usando " + r1.getName() + " e " + r2.getName());
                    TimeUnit.SECONDS.sleep(new Random().nextInt(3));
                    r1.semaforo.release();
                    r2.semaforo.release();
                    System.out.println(this.getName() + " sta usando " + r1.getName() + " e " + r2.getName());
                }
            } catch (InterruptedException e) {
                System.out.println(this.getName() + " è terminato");
                break;
            }
        }  
    }
}
