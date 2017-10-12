import java.util.concurrent.Semaphore;
import java.util.Random;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Task implements Runnable{
	private Random random;
	private Resource[] r;


	public Task(Resource r1){
		random = new Random((new Date()).getTime());
		this.r = new Resource [1];
		this.r[1] = r1;
	}

	public Task(Resource r1, Resource r2){
		random = new Random((new Date()).getTime());
		this.r = new Resource [2];
		this.r[1] = r1;
		this.r[2] = r2;
	} 

	@Override
	public void run(){
		try{
			TimeUnit.SECONDS.sleep(random.nextInt(4) + 1);
			if(r.length == 1){
				r[1].semaphore.acquire();
				r[1].semaphore.release();
			} else {
				r[1].semaphore.acquire();
				r[2].semaphore.acquire();
				r[1].semaphore.release();
				r[2].semaphore.release();
			}
		} catch(InterruptedException e){}	
	}
}
