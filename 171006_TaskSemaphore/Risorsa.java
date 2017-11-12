
import java.util.concurrent.Semaphore;

public class Risorsa{
	private Semaphore semaphore;
package test;
import java.util.concurrent.Semaphore;

/**
 *
 * @author giacomo.ravagnan
 */

public class Risorsa{
	Semaphore semaphore;
	public String name;
	
	public Risorsa(String name){
	this.name=name;
	semaphore=new Semaphore(1,true);	 
	}
	public String getName(){
		return name;
	}
}


