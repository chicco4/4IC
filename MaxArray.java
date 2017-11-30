package max;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MaxArray {
	
}
class Section extends Thread {
	
	int[] arrayTot;
	int[] myPart;
	int numThreads;
	int helpVariable = 0;
	int max = Integer.MIN_VALUE;
	static CountDownLatch sync;
	
	public Section(int[] a, int numThreads, int help) {
		helpVariable = help;
		if(helpVariable == 0)
			sync = new CountDownLatch(numThreads);
		arrayTot = a;
		this.numThreads = numThreads;
		if(helpVariable < numThreads - 1)
			myPart = new int[arrayTot.length / this.numThreads];
		else myPart = new int[arrayTot.length / this.numThreads + arrayTot.length % this.numThreads];
		//System.out.println(helpVariable);
	}

	@Override
	public void run() {
		int j = helpVariable * (int) (arrayTot.length / numThreads);
		for(int i = 0; i < myPart.length; i++) {
			myPart[i] = arrayTot[j++];
			if(i == 0) max = myPart[i];
			else if(max < myPart[i]) max = myPart[i];
		}
		sync.countDown();
	}
	public static void main(String[] args) {
		int[] array = new int[new Random().nextInt(500)];
		for(int i = 0; i < array.length; i++) {
			array[i] = new Random().nextInt(100);
		}
		System.out.println(Arrays.toString(array));
		int numThreads = new Random().nextInt(20); //cambiare questa variabile per usare una quantità di threads
		Section[] threads = new Section[numThreads];
		for(int i = 0; i < threads.length; i++) {
			threads[i] = new Section(array, numThreads, i);
			threads[i].start();
		}
		int THEMAXOFTHEMAX = Integer.MIN_VALUE;
		try {
			Section.sync.await();
			int[] maximums = new int[threads.length];
			for(int i = 0; i < maximums.length; i++) {
				maximums[i] = threads[i].max;
				if(i == 0) THEMAXOFTHEMAX = maximums[i];
				else if(THEMAXOFTHEMAX < maximums[i]) THEMAXOFTHEMAX = maximums[i];
			}
		} catch(InterruptedException ex) {
			ex.printStackTrace();
		}
		System.out.println("The MAX OF THE MAX is ... " + THEMAXOFTHEMAX);
	}
	
}