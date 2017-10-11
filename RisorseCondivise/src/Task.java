import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

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
        for (; ; ) {
            try {
                TimeUnit.SECONDS.sleep(new Random().nextInt(2));
                if (r2 == null) {
                    r1.tlight.acquire();
                    System.out.println(this.getName() + " has " + r1.getName());
                    TimeUnit.SECONDS.sleep(new Random().nextInt(3));
                    r1.tlight.release();
                    System.out.println(this.getName() + " released " + r1.getName());
                }
                else{
                    r1.tlight.acquire();
                    r2.tlight.acquire();
                    System.out.println(this.getName() + " has " + r1.getName() + " and " + r2.getName());
                    TimeUnit.SECONDS.sleep(new Random().nextInt(3));
                    r1.tlight.release();
                    r2.tlight.release();
                    System.out.println(this.getName() + " released " + r1.getName() + " and " + r2.getName());
                }
            } catch (InterruptedException e) {
                System.out.println(this.getName() + " has been terminated");
                break;
            }
        }
    }
}