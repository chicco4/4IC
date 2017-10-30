package simul1;

import java.util.concurrent.Semaphore;

/**
 *
 * @author michele.argenti
 */
public class Simul1{
	static Semaphore Semaforo = new Semaphore(1);
	static class MyATMThread extends Thread {
		String nome = "";
		MyATMThread(String name) {
			this.nome = name;
		}
		@Override
		public void run() {
			try {
				System.out.println(nome + " : aquisizione di un Semaforo...");
				System.out.println(nome + " : Semaforo disponibile ora: "+ Semaforo.availablePermits());
				Semaforo.acquire();
				System.out.println(nome + " : ottenuto il permesso!");
				try {
					System.out.println(nome + " : sta eseguendo l'operazione con il semaforo, Semafori disponibili: "+ Semaforo.availablePermits());
					System.out.println(nome + " : l'altro Thread non esegue l'operazione col Semaforo in quanto non ve ne sono disponibili ");
				} finally {
					System.out.println(nome + " : rilascio Semaforo...");
					Semaforo.release();
					System.out.println(nome + " : disponibili Semafori adesso: "+ Semaforo.availablePermits());
				}
			} catch (InterruptedException e) {
			}
		}
	}
	public static void main(String[] args) {
		System.out.println("Totale semafori disponibili: "+ Semaforo.availablePermits());
		MyATMThread t1 = new MyATMThread("Thread A");
		t1.start();
		MyATMThread t2 = new MyATMThread("Thread B");
		t2.start();
	}
}