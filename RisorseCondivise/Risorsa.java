import java.util.concurrent.Semaphore;

public class Risorsa{
	public Semaphore semaphore;
	private int numero;
	
	public Risorsa(int numero){
		this.numero = numero;
		semaphore = new Semaphore(1, true);
	}
	
	/*public void setNumero(int arg){
		this.numero = arg;
	}
	public int getNumero(){
		return numero;
	}*/
}
