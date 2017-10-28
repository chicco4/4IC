import java.util.concurrent.Semaphore;

public class Task extends Thread{
	Semaphore semaphore;
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
	}
		
}

