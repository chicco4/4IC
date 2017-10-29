import static java.lang.System.nanoTime;
import java.lang.Math;
import java.util.Random;
import java.util.Arrays;

public class TestMergeSort{
	private final static int MINIMO = 0;
	private final static int MASSIMO = 1000;
	private final static int DIMENSIONI = 100000000;
	
	public static void main(String[] args){
		long start;
		long tempo;
		int[] array;
		int[] arrayTmp;
		
		//generazione array casuale
		System.out.println("Generazione array casuale di " + DIMENSIONI + " con numeri da " + MINIMO + " a " + MASSIMO);
		start = nanoTime();
		array = arrayRandom(DIMENSIONI, MINIMO, MASSIMO);
		tempo = nanoTime() - start;
		System.out.print("Tempo impiegato: ");
		System.out.println(((tempo) / 1000) / 1000.0 + "ms\n");
		
		//merge sort ricorsivo con un solo thread
		System.out.println("Ordinamento array con merge sort ricorsivo con un solo thread");
		start = nanoTime();
		arrayTmp = MergeSort.mergeSortRecursive(array);
		tempo = nanoTime() - start;
		//System.out.println(Arrays.toString(arrayTmp)); //test corretto funzionamento algoritmo di ordinamento
		System.out.print("Tempo impiegato: ");
		System.out.println(((tempo) / 1000) / 1000.0 + "ms\n");

		//merge sort ricorsivo con due thread
		System.out.println("Ordinamento array con merge sort ricorsivo con due thread");
		start = nanoTime();
		arrayTmp = MergeSort.mergeSortRecursiveMultiThreading(array);
		tempo = nanoTime() - start;
		//System.out.println(Arrays.toString(arrayTmp)); //test corretto funzionamento algoritmo di ordinamento
		System.out.print("Tempo impiegato: ");
		System.out.println(((tempo) / 1000) / 1000.0 + "ms\n");
	}
	
	/**
	 Generazione array di numeri interi casuali
	 @param length Lunghezza dell'array da generare
	 @param min Valore minimo (incluso)
	 @param max Valore massimo (incluso)
	 @return Array
	 */
	public static int[] arrayRandom(int length, int min, int max) {
		Random generatore = new Random(System.currentTimeMillis());
		int[] array = new int[length];
		for (int i = 0; i < length; i++) {
			array[i] = generatore.nextInt(max+1 - min) + min;
		}
		return array;
	}
}
