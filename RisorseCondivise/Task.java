import java.util.concurrent.Semaphore;
import java.util.Random;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;

public class Task implements Runnable{
	private Random random;
	private Risorsa risorsa1;
	private Risorsa risorsa2;
	private boolean dueRisorse;
	
	public Task(Risorsa risorsa){
		random = new Random((new Date()).getTime());
		this.risorsa1 = risorsa;
		dueRisorse = false;
	}
	
	public Task(Risorsa risorsa1, Risorsa risorsa2){
		random = new Random((new Date()).getTime());
		this.risorsa1 = risorsa1;
		this.risorsa2 = risorsa2;
		dueRisorse = true;
	}
	
	@Override
	public void run(){
		try{
			TimeUnit.SECONDS.sleep(random.nextInt(4) + 1); //aspetto del tempo (1-4 sec)
			if(!dueRisorse){
				risorsa1.semaphore.acquire();
				//inizio esecuzione operazioni sulla risorsa
				risorsa1.semaphore.release(); //termino operazioni sulla risorsa
			} else {
				risorsa1.semaphore.acquire(); 
				//inizio esecuzione operazioni sulla risorsa 1
				risorsa2.semaphore.acquire();
				//inizio esecuzione operazioni sula risorsa 2
				risorsa1.semaphore.release(); //termino operazioni sulla risorsa 1
				risorsa2.semaphore.release(); //termino operazioni sulla risorsa 2
			}
		} catch(InterruptedException e){}	
	}
}
