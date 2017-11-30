/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trovamaxarray;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
/**
 *
 * @author marco.pistollato
 */
public class TrovaMaxArray {
	public static void main(String[] args) {  
		int[] array=generaNumeri(200);
		int threadUtilizzati=10;
		int[] risultati=new int[threadUtilizzati];
		int sezione=array.length/threadUtilizzati;
		CountDownLatch controller=new CountDownLatch(threadUtilizzati);
		for (int i=0; i<threadUtilizzati; i++) {
			int j=i;
			new Thread(() -> {
				int max=-1;
				for (int k=0; k<sezione; k++) {
					if(max<array[k]) {
						max=array[k];
					}
				}
				risultati[j]=max;
				controller.countDown();
			}).start();
		}
		int max = risultati[0];
		for (int i=1; i<risultati.length; i++) {
			if(max<risultati[i]) {
				max=risultati[i];
			}
		}
		System.out.println("Il massimo numero trovato è: "+max);
	}

	public static int[] generaNumeri(int n) {
        int[] array=new int[n];
        Random r=new Random();
        for(int i=0; i<array.length; i++){
            array[i]=r.nextInt(1000);
        }
        return array;
	}
}