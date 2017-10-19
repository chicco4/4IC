import java.util.concurrent.TimeUnit;

public class Simul1{
	public static void main(String[] args){
		Risorsa uno=new Risorsa("r1");
		Thread primo=new Task("primo",uno);
		Thread secondo=new Task("secondo",uno);
		primo.start();
		secondo.start();
		try{
			TimeUnit.SECONDS.sleep(10);
			primo.stop();
			secondo.stop();
		}catch (InterruptedException e) {
            e.printStackTrace();
		}
	}
}
