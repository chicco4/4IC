package ricercamaggiore;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RicercaMaggiore {
	public static void main(String[] args) {
		int max = Integer.MIN_VALUE;
		int[] array = new int[100];
		int inizio=0;
		int fine=25;
		Random r = new Random();
		int[] maggiori = new int[4];
		for (int i = 0; i < array.length; i++) {
			array[i] = r.nextInt(11);
		}
		Thread a;
		for (int i = 0; i < 4; i++) {
			a = new maggiore(array,inizio ,fine , maggiori);
			a.start();
			try {
				a.join();
			} catch (InterruptedException ex) {
				Logger.getLogger(RicercaMaggiore.class.getName()).log(Level.SEVERE, null, ex);
			}
			inizio=inizio+25;
			fine=fine+25;
		}

		for (int j = 0; j < maggiori.length; j++) {
			if (maggiori[j] > max) {
				max = maggiori[j];
			}
		}
		System.out.println(max);
	}
}
