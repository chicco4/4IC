public class Simul3{
	public static void main(String args[]){
		Risorsa risorsa1 = new Risorsa(1);
		Risorsa risorsa2 = new Risorsa(2);
		Task task1 = new Task(risorsa1, risorsa2);
		Task task2 = new Task(risorsa2, risorsa1);
		Thread thread1 = new Thread(task1);
		Thread thread2 = new Thread(task2);
		
		thread1.start();
		thread2.start();
		
		try{
			thread1.join();
			thread2.join();
		}catch(InterruptedException e){}
	}
}
