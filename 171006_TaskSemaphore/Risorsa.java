<<<<<<< HEAD
import java.util.concurrent.Semaphore;

public class Risorsa{
	private Semaphore semaphore;
=======
package test;
import java.util.concurrent.Semaphore;

/**
 *
 * @author giacomo.ravagnan
 */

public class Risorsa{
	Semaphore semaphore;
>>>>>>> ccc0d11c21639228754928ce12a4da03a5369b4f
	public String name;
	
	public Risorsa(String name){
	this.name=name;
	semaphore=new Semaphore(1,true);	 
	}
	public String getName(){
		return name;
	}
}


