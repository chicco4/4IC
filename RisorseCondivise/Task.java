import java.util.concurrent.Semaphore;
import java.util.Random;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;

public class Task implements Runnable{
	private Random random;
	private Risorsa[] risorse;
	
	public Task(Risorsa[] risorse){
		this.risorse = risorse;
		random = new Random((new Date()).getTime());
	}
	
	@Override
	public void run(){
		int indice = 0;
		while(indice <= risorse.length){
			if(indice < risorse.length) risorse[indice].semaphore.acquire(); //apertura risorsa numero indice
			//operazioni
			
			if(indice > 0) risorse[indice-1].semaphore.release(); //chiusura risorsa numero indice-1
			indice++;
		}
	}
}
