import java.util.ArrayList;

public class NumMax extends Thread{
	
	private int[] array;
	private int start,end;
	private int risultato;
	private ArrayList<Integer> risultati;
	
	public NumMax(int[] array,int start,int end,ArrayList risultati){
		this.array=array;
		this.start=start;
		this.end=end;
		this.risultati=risultati;
	}
	
	public void run(){
		risultato=array[start];
		for(int i=start;i<end;i++)
			if(array[i]>=risultato) risultato=array[i];
		risultati.add(risultato);
	}
}

