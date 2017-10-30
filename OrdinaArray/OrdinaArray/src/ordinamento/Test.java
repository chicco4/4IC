/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordinamento;

import static java.lang.System.nanoTime;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author francesco.fortunato
 */
public class Test {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) throws InterruptedException {
                Random random = new Random();
                int[] c = new int[100000];
                for(int i = 0; i < c.length; i++) {
                    c[i] = random.nextInt(100);
                }
                long start = nanoTime() / 1000000;
		int[] a = Sort.sort(c,2);
                long end = nanoTime() / 1000000;
                System.out.println("Ordinamento con " + Sort.quantiThread() + " thread in " + (end - start) + " ms");
                for(int i = 0; i < a.length; i++) {
                       System.out.println("Posizione " + i + ":  " + a[i]);
                }
                    
	}
	
}
