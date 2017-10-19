import java.util.concurrent.TimeUnit;
import java.util.Random;

public class Task extends Thread{
	Risorsa uno,due;
	
	public Task(String nome,Risorsa uno,Risorsa due){
		super(nome);
		this.uno=uno;
		this.due=due;
	}
	
	public Task(String nome,Risorsa uno){
		this(nome,uno,null);
	}
	
	@Override
	public void run(){
		try{
			for(;;)
			{
				TimeUnit.SECONDS.sleep(new Random().nextInt(2));
				if(due==null){
					uno.acquire();
					int random=new Random().nextInt(4);
					System.out.println("Thread "+currentThread().getName()+" sta utilizzando la risorsa " +uno.nome+" per "+random+" secondi.");
					TimeUnit.SECONDS.sleep(random);
					uno.release();
				} else{
					uno.acquire();
					due.acquire();
					int random=new Random().nextInt(4);
					System.out.println("Thread "+currentThread().getName()+" sta utilizzando la risorsa " +uno.nome+" per "+random+" secondi.");
					System.out.println("Thread "+currentThread().getName()+" sta utilizzando la risorsa " +due.nome+" per "+random+" secondi.");
					TimeUnit.SECONDS.sleep(random);
					uno.release();
					due.release();
				}
			}
		} catch (InterruptedException e) {
            e.printStackTrace();
		}
	}
	
}
