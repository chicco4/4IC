
/**

 @author Davide
 @version 0.1
 */
public class ArrayUtil {

	/**
	 Ordinamento array di interi con l'algoritmo "Selection sort"

	 @param arg Array da ordinare
	 @return Nuovo array ordinato
	 */
	//selection sort
	public static int[] selectionSort(int[] arg) {
		int[] array = new int[arg.length];
		for (int i = 0; i < arg.length; i++) {
			array[i] = arg[i];
		}

		for (int i = 0; i < array.length; i++) {
			//posizione numero minore
			int minPos = i;
			for (int j = i + 1; j < array.length; j++) {
				if (array[j] < array[minPos]) {
					minPos = j;
				}
			}
			//swap(minPos, i)
			int tmp = array[minPos];
			array[minPos] = array[i];
			array[i] = tmp;
		}
		return array;
	}

	/**
	 Generazione array di numeri interi casuali

	 @param length Lunghezza dell'array da generare
	 @param min Minimo incluso
	 @param max Massimo incluso
	 @return Array
	 */
	//array casuale
	public static int[] arrayRandom(int length, int min, int max) {
		int[] array = new int[length];
		for (int i = 0; i < length; i++) {
			array[i] = (int) (Math.random() * (max - min + 1) + min);
		}
		return array;
	}

	/**
	 Ordinamento array di interi con l'algoritmo "Gnome sort"

	 @param arg Array da ordinare
	 @return Nuovo array ordinato
	 */
	//bubble sort
	public static int[] gnomeSort(int[] arg) {
		int[] array = new int[arg.length];
		for (int i = 0; i < arg.length; i++) {
			array[i] = arg[i];
		}

		for (int i = 0; i < array.length; i++) {
			for (int j = i; j > 0 && array[j] < array[j - 1]; j--) {
				int tmp = array[j - 1];
				array[j - 1] = array[j];
				array[j] = tmp;
			}
		}
		return array;
	}

	/**
	 Ordinamento array di interi con l'algoritmo "Bubble sort"

	 @param arg Array da ordinare
	 @return Nuovo array ordinato
	 */
	public static int[] bubbleSort(int[] arg) {
		int newn = 1;
		int length = arg.length;
		int[] array = new int[arg.length];
		for (int i = 0; i < arg.length; i++) {
			array[i] = arg[i];
		}

		boolean notSorted = true;
		while (newn != 0) {
			newn = 0;
			for (int j = 0; j < length - 1; j++) {
				if (array[j] > array[j + 1]) {
					int tmp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = tmp;
					newn = j + 1;
				}
			}
			length = newn;
		}
		return array;
	}

	/**
	 Ordinamento array di interi con l'algoritmo "Merge sort" applicato ricorsivamente

	 @param arg Array da ordinare
	 @return Nuovo array ordinato
	 */
	//merge sort recursive
	public static int[] mergeSortRecursive(int[] arg) {
		int[] array = new int[arg.length];
		int[] workingArray = new int[arg.length];
		for (int i = 0; i < arg.length; i++) {
			array[i] = arg[i];
			workingArray[i] = arg[i];
		}
		topDownSplitMerge(workingArray, 0, arg.length, array);
		return array;
	}

	private static void topDownSplitMerge(int[] B, int begin, int end, int[] A) {
		if (end - begin < 2) {
			return;
		}
		int middle = (end + begin) / 2;
		topDownSplitMerge(A, begin, middle, B);
		topDownSplitMerge(A, middle, end, B);
		topDownMerge(B, begin, middle, end, A);
	}

	private static void topDownMerge(int[] A, int begin, int middle, int end, int[] B) {
		int i = begin;
		int j = middle;
		for (int k = begin; k < end; k++) {
			if (i < middle && (j >= end || A[i] <= A[j])) {
				B[k] = A[i];
				i++;
			} else {
				B[k] = A[j];
				j = j + 1;
			}
		}
	}

	/**
	 Ordinamento array di interi con l'algoritmo "Merge sort" applicato iterativamente

	 @param arg Array da ordinare
	 @return Nuovo array ordinato
	 */
	//merge sort iterative
	public static int[] mergeSortIterative(int[] arg) {
		int min0, min1;
		int[] tmp;
		int[] array = new int[arg.length];
		int[] workingArray = new int[arg.length];
		for (int i = 0; i < arg.length; i++) {
			array[i] = arg[i];
			workingArray[i] = arg[i];
		}
		for (int width = 1; width < workingArray.length; width *= 2) {
			for (int i = 0; i < workingArray.length; i = i + 2 * width) {
				if (i + width < workingArray.length) {
					min0 = i + width;
				} else {
					min0 = workingArray.length;
				}
				if (i + 2 * width < workingArray.length) {
					min1 = i + 2 * width;
				} else {
					min1 = workingArray.length;
				}
				bottomUpMerge(array, i, min0, min1, workingArray);
			}
			tmp = workingArray;
			workingArray = array;
			array = tmp;
		}
		return array;
	}

	private static void bottomUpMerge(int[] A, int left, int right, int end, int[] B) {
		int i = left;
		int j = right;
		for (int k = left; k < end; k++) {
			if (i < right && (j >= end || A[i] <= A[j])) {
				B[k] = A[i];
				i++;
			} else {
				B[k] = A[j];
				j++;
			}
		}
	}

	/**
	 Ordinamento array di interi con l'algoritmo "Radix sort LSD" (LSD = analizzando i numeri da destra verso sinistra)
	 prova 0

	 @param arg Array da ordinare
	 @return Nuovo array ordinato
	 */
	//radix sort LSD
	public static int[] radixSortLSD(int[] arg) {
		int[] array = new int[arg.length];
		for (int i = 0; i < arg.length; i++) {
			array[i] = arg[i];
		}

		int divisore = 1;
		int cifra;
		int j, k;
		boolean notFinished = true;
		int[][] buckets = new int[10][array.length];
		int[] length = new int[10];

		while (notFinished) {
			for (int i = 0; i < array.length; i++) {
				cifra = (array[i] % (divisore * 10)) / divisore;
				buckets[cifra][length[cifra]] = array[i];
				length[cifra]++;
			}
			j = 0;
			k = 0;
			while (j < 10) {
				for (int i = 0; i < length[j]; i++, k++) {
					array[k] = buckets[j][i];
				}
				j++;
			}
			divisore *= 10;
			for (int i = 0; i < length.length; i++) {
				if (array.length == length[i]) {
					notFinished = false;
				}
			}
			for (int i = 0; i < length.length; i++) {
				length[i] = 0;
			}
		}

		return array;
	}

	/**
	 Ordinamento array di interi con l'algoritmo "Radix sort LSD" (LSD = analizzando i numeri da destra verso sinistra)
	 prova 1

	 @param arg Array da ordinare
	 @return Nuovo array ordinato
	 */
	//radix sort LSD trying to improve
	public static int[] radixSortLSD1(int[] arg) {
		int[] array = new int[arg.length];
		for (int i = 0; i < arg.length; i++) { //duplico array
			array[i] = arg[i];
		}
		int divisore = 1;
		int cifra;
		int j, k;
		boolean notFinished = true;
		int[][] buckets = new int[10][array.length];
		int[] length = new int[10];

		while (notFinished) {
			for (int i = 0; i < array.length; i++) {
				cifra = (array[i] % (divisore * 10)) / divisore; //analizzo una cifra alla volta partendo da sinistra
				buckets[cifra][length[cifra]] = array[i]; //salvo il numero nel secchio corrispondende all cifra presa in analisi
				length[cifra]++; //aumento di uno la lunghezza del secchio
			}

			if (array.length == length[0]) {
				break; //controllo che non sia stato messo tutto nel secchio 0
			}

			j = 0;
			k = 0;
			while (j < 10) {
				for (int i = 0; i < length[j]; i++, k++) { //rimetto tutto nell'array, col nuovo ordine
					array[k] = buckets[j][i];
				}
				j++;
			}

			divisore *= 10; //mi sposto alla cifra successiva
			for (int i = 0; i < length.length; i++) {
				length[i] = 0; //azzero le lunghezze dei secchi
			}
		}
		return array;
	}

	/**
	 Ordinamento array di interi con l'algoritmo "Radix sort LSD" (LSD = analizzando i numeri da destra verso sinistra)
	 prova 2

	 @param arg Array da ordinare
	 @return Nuovo array ordinato
	 */
	//radix sort LSD "inverse buckets" (slow)
	public static int[] radixSortLSD2(int[] arg) {
		int[] array = new int[arg.length];
		for (int i = 0; i < arg.length; i++) { //duplico array
			array[i] = arg[i];
		}

		int divisore = 1;
		int cifra;
		int j, k;
		int controllo = 10;
		boolean notFinished = true;
		int[] array2 = new int[array.length];
		byte[] whichBucket = new byte[array.length];

		while (controllo > 1) {
			controllo = 0;
			for (int i = 0; i < array.length; i++) {
				cifra = (array[i] % (divisore * 10)) / divisore; //analizzo una cifra alla volta partendo da sinistra
				whichBucket[i] = (byte) cifra;
				controllo |= 1 << cifra;
			}

			j = 0;
			k = 0;
			while (j < 10) {
				for (int i = 0; i < array.length; i++) { //rimetto tutto nell'array, col nuovo ordine
					if (whichBucket[i] == j) {
						array2[k] = array[i];
						k++;
					}
				}
				j++;
			}
			for (int i = 0; i < array.length; i++) { //duplico array
				array[i] = array2[i];
			}

			divisore *= 10; //mi sposto alla cifra successiva
		}
		return array;
	}

	/**
	 Ricerca di un elemento all'interno dell'array

	 @param array Array dove cercare l'elemento
	 @param element Elemento da cerca nell'array
	 @return Prima posizione dell'elemento dato in input (-1 se non presente)
	 */
	public static int search(int[] array, int element) {
		int i;
		for (i = 0; i < array.length; i++) {
			if (element == array[i]) {
				return i;
			}
		}
		return -1;
	}

	/**
	 Ricerca con sentinella di un elemento all'interno dell'array

	 @param array Array dove cercare l'elemento (con l'ultima cella vuota!)
	 @param element Elemento da cerca nell'array
	 @return Prima posizione dell'elemento dato in input (-1 se non presente)
	 */
	public static int searchWithSentinel(int[] array, int element) {
		int i;
		array[array.length - 1] = element;
		for (i = 0; array[i] != element; i++);
		if (i < array.length) {
			return i;
		} else {
			return -1;
		}
	}

	/**
	 Ricerca di un elemento all'interno di un array ordinato

	 @param array Array ordinato dove cercare l'elemento
	 @param element Elemento da cercare nell'array
	 @return Prima posizione dell'elemento dato in input (-1 se non presente)
	 */
	public static int searchDicotomica(int[] array, int element) {
		int begin, end, middle, lastMiddle;
		begin = 0;
		end = array.length;
		middle = (end + begin) / 2;
		lastMiddle = -1;

		while (array[middle] != element && middle != lastMiddle) {
			if (array[middle] < element) {
				begin = middle;
			} else {
				end = middle;
			}
			lastMiddle = middle;
			middle = (begin + end) / 2;
		}
		while (array[middle] != element) {
			middle--;
		}
		middle++;
		return middle;
	}

}
