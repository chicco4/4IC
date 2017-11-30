/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package findmaxthreads;

import java.util.concurrent.CountDownLatch;

/**
 *
 * @author andrea.dattero
 */
public class Cercatore implements Runnable {
	private int max = 0, valMax = 0;
	private int pos0, pos1;
	private int[] array, arrayMaggiori;
	public Cercatore(int pos0, int pos1, int[] array, int[] arrayMaggiori) {
		this.pos0 = pos0;
		this.pos1 = pos1;
		this.array = array;
		this.arrayMaggiori = arrayMaggiori;
	}

	public Cercatore(int pos0, int pos1, int[] array, int valMax) {
		this.pos0 = pos0;
		this.pos1 = pos1;
		this.array = array;
		this.valMax = valMax;
	}

	@Override
	public void run() {
		for (int i = pos0; i < pos1; i++) {
			if (this.max < array[i]) {
				this.max = array[i];
			}
		}
		if (this.arrayMaggiori != null) {
			for (int i = 0; i < this.arrayMaggiori.length; i++) {
				if (this.arrayMaggiori[i] < 1) {
					this.arrayMaggiori[i] = this.max;
					break;
				}
			}
		} else {
			this.valMax = this.max;
			System.out.println("il valore maggiore è: "+this.max);
		}
		FindMaxThreads.finish.countDown();
	}

}
