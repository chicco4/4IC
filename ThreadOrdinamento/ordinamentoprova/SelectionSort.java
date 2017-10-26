package ordinamentoprova;

import java.text.DecimalFormat;

/**
 *
 * @author matteo
 */
public class SelectionSort extends Thread {

    private int[] array;
    private final Thread thread;

    public SelectionSort(int[] array, Thread thread) {
        this.array = array;
        this.thread = thread;
    }

    public void sort() {
    int length = array.length;
    int minimumValue = Integer.MAX_VALUE;

    for (int i = 0; i < length; ++i) {
        // find the minimumValue when j > i and swap it  with input[i] location
        for (int j =i; j < length; ++j) {
          if (array[j] <= minimumValue ) {
            minimumValue = array[j];
            array[j] = array[i];
            array[i] = minimumValue;
          }
        }
        minimumValue = Integer.MAX_VALUE;
    }
  }

    public void run() {
        long tempo = getTimeSort();
        String tempoinsec = arrotondaPerDifetto((double) tempo / 1000000000);
        System.out.println("Tempo impiegato per il SelectionSort: " + tempo + " nano secondi o circa " + tempoinsec + " secondi");
    }

    private long getTimeSort() {
        System.out.println("Inizio riordinamento array SelectionSort...");
        long startTime = System.nanoTime();
        sort();
        System.out.println("Fine riordinamento array SelectionSort...");
        long estimatedTime = System.nanoTime() - startTime;
        return estimatedTime;
    }

    public void stampa() {
        for (int i = 1; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    private static String arrotondaPerDifetto(double value) {

        DecimalFormat df = new DecimalFormat("#.#####"); // 2 cifre decimali

        return df.format(value);
    }

}
