package maxarray;

import java.util.ArrayList;

public class MaxElementArray extends Thread{
	
	private int[] array;
	private int inizio,fine;
	private int risultato;
	private ArrayList<Integer> risultati;
	
	public MaxArray(int[] array,int inizio,int fine,ArrayList risultati){
		this.array=array;
		this.inizio=inizio;
		this.fine=fine;
		this.risultati=risultati;
	}
	
	public void run(){
		risultato=array[inizio];
		for(int i=inizio;i<fine;i++)
			if(array[i]>=risultato) risultato=array[i];
		risultati.add(risultato);
	}
}
