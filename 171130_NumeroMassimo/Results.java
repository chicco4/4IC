import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

public class Results extends Thread{
	
	private int[] array;
	private int start,end,Parti,numeroThread;
	private ArrayList<Integer> risultati=new ArrayList();
	private CountDownLatch cdl;

	public Results(int[] array,int numeroThread){
		cdl=new CountDownLatch(numeroThread);
		Parti=array.length/numeroThread;
		this.numeroThread=numeroThread;
		this.array=array;
	}
	
	public void run(){
		start=0;
		end=0;
		for(int i=0;i<numeroThread;i++){
			end+=Parti;
			Thread t=new NumMax(array,start,end-1,risultati);
			start=end;
			t.start();
			cdl.countDown();
		}
		
		try{
			cdl.await();
			int risultato=risultati.get(0);
			for(int i=0;i<risultati.size()-1;i++)
				if(risultati.get(i)>=risultato) risultato=risultati.get(i);
			System.out.println("Numero Massimo: "+risultato);
		} catch(Exception e){
			e.printStackTrace();
		}
	}
}
	
