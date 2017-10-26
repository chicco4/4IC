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

    public void sort() {
        int temp = 0;
        int j = array.length - 1;
        while (j > 0) {
            for (int i = 0; i < j; i++) {
                if (array[i] > array[i + 1]) //scambiare il '>' con '<' per ottenere un ordinamento decrescente
                {
                    temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }
            j--;
        }
    }

    public void run() {
        long tempo = getTimeSort();
        String tempoinsec=arrotondaPerDifetto((double)tempo/1000000000);
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

        return  df.format(value);
    }
}
