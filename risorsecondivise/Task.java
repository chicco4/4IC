package risorsecondivise;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andrea Dattero
 */
public class Task implements Runnable {

    Risorse[] risorse;
    Risorse questa;
    String nome;
    int time;
    Semaphore s;

    Task(Risorse[] risorse, String nome, int time) {
        this.risorse = risorse;
        this.nome = nome;
        this.time = time;
    }

    @Override
    public void run() {
        this.setRisorsa();
        while (!this.s.tryAcquire()) {

        }
        int time1 = time;
        for (int i = 0; i < this.risorse.length; i++) {
            while (this.time > 0) {
                System.out.println(this.nome + " sta utilizzando la risorsa: " + this.questa.getName());
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Task.class.getName()).log(Level.SEVERE, null, ex);
                }
                this.time--;
            }
            this.s.release();
            this.setRisorsa();
            this.time = time1;
        }

    }

    public void setRisorsa() {
        for (int i = 0; i < this.risorse.length; i++) {
            if (this.s!= this.risorse[i].getSemaphore()) {
                this.questa = this.risorse[i];
                this.s = this.risorse[i].getSemaphore();
                break;
            }
        }
    }
}
