public class Simul1{
	public static void main(String args[]){
		Risorsa risorsa = new Risorsa(1);
		Task task1 = new Task(risorsa);
		Task task2 = new Task(risorsa);
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
