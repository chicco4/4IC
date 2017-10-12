import java.util.concurrent.Semaphore;

public class Resource{
	public Semaphore semaphore;
	private int info;
	
	public Resource(int info){
		this.info = info;
		semaphore = new Semaphore(1, true);
	}
	
		public void setInfo(int arg){
		this.info = arg;
	}
	public int getInfo(){
		return info;
	}
}
