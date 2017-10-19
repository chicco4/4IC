package test;
import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author giacomo.ravagnan
 */
public class Task extends Thread{
	 private Semaphore semaphore;
	Risorsa risorsa1;
	Risorsa risorsa2;
	
	public Task(Risorsa r1, Risorsa r2){
		this.risorsa1=r1;
		this.risorsa2=r2;
	}
	
	public Task(Risorsa r1){
		this.risorsa1=r1;
		this.risorsa2=null;
	}
	
	public void run(){
	while(true){
            try {
                TimeUnit.SECONDS.sleep(new Random().nextInt(5));
                if (risorsa2 == null) {
                    risorsa1.semaphore.acquire();
                    System.out.println("Thread: "+this.getName() + " acquired " + risorsa1.getName());
                    TimeUnit.SECONDS.sleep(new Random().nextInt(3));
                    risorsa1.semaphore.release();
                    System.out.println("Thread: "+this.getName() + " released " + risorsa1.getName());
                }
                else{
                    risorsa1.semaphore.acquire();
                    risorsa2.semaphore.acquire();
                    System.out.println("Thread: "+this.getName() + " acquired " + risorsa1.getName());
                    System.out.println("Thread: "+this.getName() + " acquired " + risorsa2.getName());
                    TimeUnit.SECONDS.sleep(new Random().nextInt(5));
                    risorsa1.semaphore.release();
                    risorsa2.semaphore.release();
                    System.out.println("Thread: "+this.getName() + " released " + risorsa1.getName());
                    System.out.println("Thread: "+this.getName() + " released " + risorsa2.getName());
                }
            } catch (InterruptedException e) {
                System.out.println(this.getName() + " has stopped");
                break;
            }
	}
		
}
}

