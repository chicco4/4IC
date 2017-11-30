package findmaxthreads;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 *
 * @author andrea.dattero
 */
public class FindMaxThreads {
	static CountDownLatch finish;
	
	
	
	public static void main(String[] args) throws InterruptedException {
		int nThreads=4,pos0=0;
		int[] array = new int[12],arrayMaggiori= new int[nThreads];
		int pos1=array.length/nThreads;
		
		
		
		
		
		for (int i = 0; i < nThreads; i++) {
			arrayMaggiori[i]=0;
		}
		
		
		for (int i = 0; i < array.length; i++) {
			array[i]= new Random().nextInt(10);
		}
		System.out.println(Arrays.toString(array));
		
		
		
		finish= new CountDownLatch(nThreads);
		
		for (int i = 0; i < nThreads; i++) {
			
			Thread t=new Thread(new Cercatore(pos0,pos1,array,arrayMaggiori));
			t.start();
			pos0= pos1;
			pos1+=array.length/nThreads;
		}
		finish.await();
		int val=0;
		
		System.out.println(Arrays.toString(arrayMaggiori));
		new Thread(new Cercatore(0,arrayMaggiori.length,arrayMaggiori,val)).start();
		
	}
	
}
