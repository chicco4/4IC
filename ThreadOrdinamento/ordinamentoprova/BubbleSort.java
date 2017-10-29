package ordinamentoprova;

import java.text.DecimalFormat;

/**
 *
 * @author matteo
 */
public class BubbleSort extends Thread {

    private final int[] array;
    private final Thread thread;

    public BubbleSort(int[] array, Thread thread) {
        this.array = array;
        this.thread = thread;
    }

    private void sort() {

        int n = array.length;
        int temp = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (array[j - 1] > array[j]) {
                    //swap the elements!
                    temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                }

            }
        }
    }
       

    @Override
    public void run() {
        long tempo = getTimeSort();
        String tempoinsec = arrotondaPerDifetto((double) tempo / 1000000000);
        System.out.println("Tempo impiegato per il BubbleSort: " + tempo + " nano secondi o circa " + tempoinsec + " secondi");
    }

    private long getTimeSort() {
        System.out.println("Inizio riordinamento array BubbleSort...");
        long startTime = System.nanoTime();
        sort();
        System.out.println("Fine riordinamento array SelectionSort...");
        long estimatedTime = System.nanoTime() - startTime;
        return estimatedTime;
    }

    public void stampa() {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    private static String arrotondaPerDifetto(double value) {

        DecimalFormat df = new DecimalFormat("#.#####"); // 2 cifre decimali

        return df.format(value);
    }
}
