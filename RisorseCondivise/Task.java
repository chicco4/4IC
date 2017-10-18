/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package risorsecondivise;
/**
 *
 * @author Marco
 */
public class Task implements Runnable {
    private Risorsa r1;
    private Risorsa r2;
    
    public Task(Risorsa r) {
        r1=r;
    }
    
    public Task(Risorsa r1, Risorsa r2) {
        this.r1=r1;
        this.r2=r2;
    }
   
    @Override
    public void run() {
        if(r2==null) {
            System.out.println(Thread.currentThread().getName()+": sta andando ad acquisire la risorsa "+r1.getNomeRisorsa());
            r1.durataAcquisizioneRisorsa();
            r1.semaforo.release();
            System.out.println(Thread.currentThread().getName()+": ha rilasciato la risorsa " + r1.getNomeRisorsa());
        } else {
            System.out.println(Thread.currentThread().getName()+": sta andando ad acquisire la risorsa "+r1.getNomeRisorsa());
            r1.durataAcquisizioneRisorsa();
            System.out.println(Thread.currentThread().getName()+": sta andando ad acquisire la risorsa "+r2.getNomeRisorsa());
            r2.durataAcquisizioneRisorsa();
            r1.semaforo.release();
            System.out.println(Thread.currentThread().getName()+": ha rilasciato la risorsa " + r1.getNomeRisorsa());
            r2.semaforo.release();
            System.out.println(Thread.currentThread().getName()+": ha rilasciato la risorsa " + r2.getNomeRisorsa());
        }
    }
}