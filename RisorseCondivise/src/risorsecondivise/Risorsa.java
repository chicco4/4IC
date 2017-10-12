package risorsecondivise;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.Semaphore;
public class Risorsa{
    static final Random random = new Random((new Date()).getTime());
    private final Semaphore semaphore;
    String name;
    public Risorsa(String name){
        this.name = name;
        this.semaphore = new Semaphore(1);
    }
    public void acquireResourse(){
	try{
            semaphore.acquire();
            int duration = 1 + random.nextInt(4);	//Per quanto tempo il thread usa la risorsa
            System.out.printf("%s: Acquiring the "+this.name+" during %d seconds\n", Thread.currentThread().getName(), duration);
            TimeUnit.SECONDS.sleep(duration);
	}catch(InterruptedException e){
            e.printStackTrace();
	}
    }
    public void releaseResourse(){
        semaphore.release();
    }
}