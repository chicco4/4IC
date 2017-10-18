/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package risorsecondivise;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.Random;

/**
 *
 * @author Marco
 */
public class Risorsa {
    protected Semaphore semaforo;
    private String nomeRisorsa;
    private Random generatore=new Random();

    public Risorsa (String nomeRisorsa){
        this.nomeRisorsa=nomeRisorsa;
        this.semaforo=new Semaphore(1);
    }

    public String getNomeRisorsa(){
        return nomeRisorsa;
    }
    
    public void durataAcquisizioneRisorsa(){
        try{
            semaforo.acquire();
            System.out.println(Thread.currentThread().getName()+" ha acquisito la risorsa "+nomeRisorsa);
            int durata=1+generatore.nextInt(5);
            TimeUnit.SECONDS.sleep(durata);
            System.out.println(Thread.currentThread().getName()+": l'acquisione della risorsa "+nomeRisorsa+" è durata "+durata+" secondi");
	} catch(InterruptedException e){
            e.printStackTrace();
	}
    }
}