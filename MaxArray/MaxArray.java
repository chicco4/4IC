import java.util.ArrayList;

public class MaxArray extends Thread{
	
	private int[] array;
	private int start,end;
	private int result;
	private ArrayList<Integer> results;
	
	public MaxArray(int[] array,int start,int end,ArrayList results){
		this.array=array;
		this.start=start;
		this.end=end;
		this.results=results;
	}
	
	public void run(){
		result=array[start];
		for(int i=start;i<end;i++)
			if(array[i]>=result) result=array[i];
		results.add(result);
	}
}
