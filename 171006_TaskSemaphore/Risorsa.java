import java.util.concurrent.Semaphore;

public class Risorsa{
	private Semaphore semaphore;
	public String name;
	
	public Risorsa(String name){
	this.name=name;
	semaphore=new Semaphore(1,true);	 
	}
	public String getName(){
		return name;
	}
}


