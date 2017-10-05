package multithread;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;
/**
 *
 * @author federico.scaggiante
 */
public class FileClock implements Runnable {      
    Thread[] threads;
    int position;
    Random r = new Random();
    Thread interrompi;
    public FileClock(Thread[] threads, int posizione) {
        this.threads = threads;
        this.position = posizione;
    }
    @Override
    public void run() {
        while(true) {
            System.out.println(""+this.position+" "+ new Date());
            try {
                TimeUnit.SECONDS.sleep(1);
                this.interrompi = this.threads[new Random().nextInt(threads.length)];
            } catch (InterruptedException e) {
                System.out.println("The Thread "+this.position+" was interrupted");
                threads=deleteThread(threads);
                return;
            }
            stop();
        }
    }   
    private void stop() {
        if(lastAlive()){
            System.out.println("Im the last alive "+this.position);
            Thread.currentThread().interrupt();
        }
        else{
            this.interrompi.interrupt();
        }
    }   
    private boolean lastAlive() {
        for (int i = 0; i < this.threads.length; i++) {
            if(this.threads[i].isAlive() && this.threads[i]!=Thread.currentThread()){
                return false;
            }
        }
        return true;
    }    
    private Thread[] deleteThread(Thread[] threads) {
        Thread[] t = new Thread[threads.length-1];
        for (int i = 0; i < t.length; i++) {
            if(threads[i]!= Thread.currentThread()){
                t[i] = threads[i];
            }
            else{
                System.out.println("I find myself in: "+this.position);
            }
        }
        return t;
    }
}