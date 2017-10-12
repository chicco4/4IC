package com.company;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.Random;
/**
 * Created by studente on 12/10/17.
 */
public class Task extends Thread{
    private Semaphore semaforo;
    private Risorse r1;
    private Risorse r2;

    public Task(Risorse r1,Risorse r2){
        this.r1=r1;
        this.r2=r2;
    }

    public Task(Risorse r1){
        this(r1,null);
    }

    @Override
    public void run() {
        for (;;) {
            try {
                TimeUnit.SECONDS.sleep(new Random().nextInt(2));
                if (r2 == null) {
                    r1.semaforo.acquire();
                    System.out.println(this.getName()+" usa la risorsa: "+r1.getName());
                    TimeUnit.SECONDS.sleep(new Random().nextInt(3));
                    r1.semaforo.release();
                    System.out.println(this.getName()+ " ha rilasciato "+r1.getName());
                }else {
                    r1.semaforo.acquire();
                    r2.semaforo.acquire();
                    System.out.println(this.getName()+" usa la risorsa "+r1.getName()+" e "+r2.getName());
                    TimeUnit.SECONDS.sleep(new Random().nextInt(3));
                    r1.semaforo.release();
                    r2.semaforo.release();
                    System.out.println(this.getName()+" ha rilasciato "+r1.getName()+" e "+r2.getName());
                }
            } catch (InterruptedException e) {
                System.out.println(this.getName()+" è terminato");
                break;
            }
        }
    }
}
