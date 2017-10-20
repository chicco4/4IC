import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Task extends Thread {

    private Random nRandom = new Random();
    private final int MAX_TIME = 3;
    private Risorsa[] risorse;
    private Risorsa r;
    private ArrayList<Thread> t = new ArrayList();
    
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
        if(r == null){
            boolean esegui = true;
            while (esegui) {
                for (int i = 0; i < risorse.length; i++) {
                    try {
                        TimeUnit.SECONDS.sleep(nRandom.nextInt(MAX_TIME) + 1);

                        Thread t1 = new Thread(new Task(risorse[i], nThread, i));
                        t.add(t1);
                        t1.start();
                        
                    } catch (InterruptedException ex) {
                        for(int j=0; j<t.size(); j++)
                            t.get(j).interrupt();
                        System.out.println("Thread"+ nThread + " has been termianted");
                        esegui = false;
                        break;
                    }
                }
            }
        } else {
            try {
                r.semaphore.acquire();
                System.out.println("Thread" + nThread + " is using Risorsa" + nRisorsa);
                TimeUnit.SECONDS.sleep(nRandom.nextInt(MAX_TIME) + 1);
                System.out.println ("Thread"+ nThread + " has finished to use Risorsa" + nRisorsa);
            } catch (InterruptedException ex) {
            } finally {
                r.semaphore.release();
            }
        }
    }
}