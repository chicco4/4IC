


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;


public class MaxArray {

	static CountDownLatch aspetta;
	
	
	public static void main(String[] args) throws InterruptedException {
		int daOrdinare[]=new int[20];
		riempi(daOrdinare);
		int numeroThread=5;
		for (int i = 0; i < daOrdinare.length; i++) {
			System.out.print(daOrdinare[i]+" ");
		}
		//System.out.println(numeroThread);
		int ris=massimo(daOrdinare, numeroThread);
		
		System.out.println("rissss" +ris);
		
	}

	private static void riempi(int[] daOrdinare) {
		Random r;
		r=new Random();
		for (int i = 0; i < daOrdinare.length; i++) {
			daOrdinare[i]=r.nextInt(10);
		
		}
	}
	
	private static int massimo(int[] daOrdinare, int numeroThread) throws InterruptedException{
		int lunghezza=daOrdinare.length/numeroThread;
		aspetta=new CountDownLatch(numeroThread);
		int inf=0;
		int sup=lunghezza;
		Integer[] massimi=new Integer[numeroThread];
		
		
		for (int i = 0; i < numeroThread; i++) {
			TrovaMax tr=new TrovaMax(daOrdinare , inf, sup, massimi, i );
			Thread t=new Thread(tr);
			t.start();

			inf=sup;
			sup+=lunghezza;
			//System.out.println(ris[i]);
		}
		aspetta.await();
		int tmp=massimi[0];
		for (int i = 0; i < massimi.length; i++) {
			if(tmp<massimi[i]){
				tmp=massimi[i];
			}
		}
		return tmp;
	}
}




class TrovaMax implements Runnable{
	private int[] daOrdinare;
	private int inf;
	private int sup;

	private Integer[]massimi;
	private int posMax;
		


	
	TrovaMax(int[] daOrdinare, int inf, int sup, Integer []massimi, int posMax) {
		this.daOrdinare=daOrdinare;
		this.inf=inf;
		this.sup=sup;
		this.massimi=massimi;
		this.posMax=posMax;
	}

	@Override
	public void run() {
		int max=daOrdinare[inf];
		for (int i = inf; i < sup; i++) {
			if(daOrdinare[i]>max){
				max=daOrdinare[i];
			}
			
		}

		massimi[posMax]=max;
		MaxArray.aspetta.countDown();
	}

	
	
}

	
	

	
	
