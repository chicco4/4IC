package tasksemaforo;

import java.util.Date;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author David
 */
public class Task {

    private Random random;
    private Risorsa[] risorse;
    private String nome;

    public Task(Risorsa[] arrayRisorse, String nome) {
        this.nome = nome;
        this.risorse = arrayRisorse;
        random = new Random((new Date()).getTime());
    }

    public Task(Risorsa singola, String nome) {
        this.nome = nome;
        risorse = new Risorsa[1];
        risorse[0] = singola;
    }

    public void job() {
        for (int pos = 0; pos < risorse.length; pos++) {
            try {
                risorse[pos].semaphore.acquire(); 
                notificaAquisizione(risorse[pos]);
            } catch (InterruptedException ex) {
                break;
            } finally {
                synchronized(risorse[pos].semaphore){
                    notificaRilascio(risorse[pos]);
                    risorse[pos].semaphore.release();
                }
            }
        }
    }

    private void notificaAquisizione(Risorsa risorsa) throws InterruptedException {
        Thread.sleep(1000);
        System.out.println(this.nome+" Ha in possesso il: "+risorsa.value);
    }

    private void notificaRilascio(Risorsa risorsa) {
        System.out.println(this.nome+" ha rillasciato il : "+risorsa.value);
    }
}
