import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Task extends Thread {

    private Random nRandom = new Random();
    private final int MAX_TIME = 3;
    private Risorsa[] risorse;
    private Risorsa r;

    private int nThread;
    private int nRisorsa;

    Task(Risorsa[] risorse, int nThread) {
        this.risorse = risorse;
        this.nThread = nThread;
    }
    
    private Task(Risorsa r, int nThread, int nRisorsa) {
        this.r = r;
        this.nThread = nThread;
        this.nRisorsa = nRisorsa;
    }

    @Override
    public void run() {
        System.out.println("ciao "+risorse.length);
        if(r == null){
            boolean esegui = true;
            while (esegui) {
                for (int i = 0; i < risorse.length; i++) {
                    try {
                        TimeUnit.SECONDS.sleep(nRandom.nextInt(MAX_TIME) + 1);

                        new Thread(new Task(risorse[i], nThread, i)).start();
                        
                    } catch (InterruptedException ex) {
                        System.out.println("Thread"+ nThread + " has been termianted");
                        esegui = false;
                        break;
                    }
                }
            }
        } else {
            try {
                r.semaphore.acquire();
                //System.out.println("Thread" + nThread + " is using Risorsa" + nRisorsa);
                TimeUnit.SECONDS.sleep(nRandom.nextInt(MAX_TIME) + 1);
                r.semaphore.release();
                System.out.println ("Thread"+ nThread + " has finished to use Risorsa" + nRisorsa);
            } catch (InterruptedException ex) {
                System.out.println("Thread"+ nThread + " has been termianted");
            }
        }
    }
}