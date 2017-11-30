import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

public class GetMax extends Thread{

	private int[] array;
	private int start,end,nParti,nThread;
	private ArrayList<Integer> results=new ArrayList();
	private CountDownLatch cd;

	public GetMax(int[] array,int nThread){
		cd=new CountDownLatch(nThread);
		nParti=array.length/nThread;
		this.nThread=nThread;
		this.array=array;
	}
	
	public void run(){
		start=0;
		end=0;
		for(int i=0;i<nThread;i++){
			end+=nParti;
			Thread t=new MaxArray(array,start,end-1,results);
			start=end;
			t.start();
			cd.countDown();
		}
		
		try{
			cd.await();
			int result=results.get(0);
			for(int i=0;i<results.size()-1;i++)
				if(results.get(i)>=result) result=results.get(i);
			System.out.println("MAX: "+result);
		} catch(Exception e){
			e.printStackTrace();
		}
	}
}
