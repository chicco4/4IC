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
    Risorse inUso;
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
        int time1 = time;//copia del time
        for (int i = 0; i < this.risorse.length; i++) {// un for per permettere al task di utilizzare tutte le risorse nell'array
            
            
            while (this.inUso == null) {// se non c'è nessuna risorsa in uso ne cerca una
                this.setRisorsa();
            }

            while (!this.s.tryAcquire()) {//cerca di acquisire il permit

            }

            while (this.time > 0) {//utilizza la risorsa fino a quando il tempo è maggiore di zero
                System.out.println(this.nome + " sta utilizzando la risorsa: " + this.inUso.getName());
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Task.class.getName()).log(Level.SEVERE, null, ex);
                }
                this.time--;
            }

            this.s.release();// rilascia il permit della risorsa
            this.inUso = null;

            while (this.inUso == null) {
                this.setRisorsa();
            }

            this.time = time1;
        }

    }

    public void setRisorsa() {
        for (int i = 0; i < this.risorse.length; i++) {
            if (this.s != this.risorse[i].getSemaphore() && this.risorse[i].getSemaphore().availablePermits() > 0) {
                this.inUso = this.risorse[i];
                this.s = this.risorse[i].getSemaphore();
                break;
            }
        }
    }
}
