/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eserciziomax;

/**
 *
 * @author matteo.pagano
 * @param <Comparable>
 */
public class Max implements Runnable {
	private int[] array;
	private int max=0;
	static int val=0;

	public Max(int[] array) {
		this.array = array;
	}

	@Override
	public void run() {
		int max = 0;
		for (int i = 0; i < this.array.length; i++) {
			if (array[i] > max) {
				max = array[i];
			}
		}
		this.max=max;
	}

	public int getMax() {
		return max;
	}

	public static void main(String[] args) {
		int[] arr = new int[200];
		riempimento(arr);
		Max a = new Max(dividi(arr,2));
		Max b = new Max(dividi(arr,1));
		a.run();
		b.run();
		System.out.println(a.getMax()+"   "+b.getMax());
		System.out.println(Math.max(a.getMax(), b.getMax()));
	}

	static int numRandom(int min, int max) {
		return (int) (Math.random() * (max - min) + min);
	}

	static void riempimento(int[] a) {
		for (int i = 0; i < a.length; i++) {
			a[i] = numRandom(1, 200);
		}
	}

	static int[] dividi(int[] array, int nthread) {
		int[] array1;
		array1 = new int[array.length / nthread];
		
		for (int i = val, j = 0; i < array.length/nthread; i++, j++) {
			array1[j] = array[i];
		}
		val+=array.length/2;
		return array1;
	}
	
	static public void stampa(int array[]){
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}
}

