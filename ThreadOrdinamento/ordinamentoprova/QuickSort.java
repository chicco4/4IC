package ordinamentoprova;

import java.text.DecimalFormat;

/**
 *
 * @author matteo
 */
public class QuickSort extends Thread {

    private final int[] array;
    private final Thread thread;
    private int low, high;

    public QuickSort(int[] array, Thread thread) {
        this.array = array;
        this.thread = thread;
        this.low = 0;
        this.high = array.length - 1;
    }

    public static void sort(int[] arr, int low, int high) {
        if (arr == null || arr.length == 0) {
            return;
        }

        if (low >= high) {
            return;
        }

        // pick the pivot
        int middle = low + (high - low) / 2;
        int pivot = arr[middle];

        // make left < pivot and right > pivot
        int i = low, j = high;
        while (i <= j) {
            while (arr[i] < pivot) {
                i++;
            }

            while (arr[j] > pivot) {
                j--;
            }

            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }

        // recursively sort two sub parts
        if (low < j) {
            sort(arr, low, j);
        }

        if (high > i) {
            sort(arr, i, high);
        }
    }

    public void run() {
        long tempo = getTimeSort();
        String tempoinsec = arrotondaPerDifetto((double) tempo / 1000000000);
        System.out.println("Tempo impiegato per il QuickSort: " + tempo + " nano secondi o circa " + tempoinsec + " secondi");
    }

    private long getTimeSort() {
        System.out.println("Inizio riordinamento array QuickSort...");
        long startTime = System.nanoTime();
        sort(this.array, this.low, this.high);
        System.out.println("Fine riordinamento array QuickSort...");
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
