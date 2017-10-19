import java.util.concurrent.TimeUnit;

public class Simul2{
	public static void main(String[] args){
		Risorsa uno=new Risorsa("r1");
		Risorsa due=new Risorsa("r2");
		Thread primo=new Task("primo",uno,due);
		Thread secondo=new Task("secondo",uno,due);
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
