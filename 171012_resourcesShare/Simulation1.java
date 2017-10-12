public class Simulation1{
	
	public static void main(String[] args){
		Resource r1 = new Resource(1);
		Task t1 = new Task(r1);
		Task t2 = new Task(r1);
		Thread thread1 = new Thread(t1);
		Thread thread2 = new Thread(t2);
		
		thread1.start();
		thread2.start();
		
		try{
			thread1.join();
			thread2.join();
		}catch(InterruptedException e){}
	}
}
