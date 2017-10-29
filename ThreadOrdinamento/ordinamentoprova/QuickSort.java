package ordinamentoprova;

import java.text.DecimalFormat;

/**
 *
 * @author matteo
 */
public class QuickSort extends Thread {

    private final int[] array;
    private final Thread thread;
    private int low, high,nThread;

    public QuickSort(int nThread,int[] array, Thread thread) {
        this.array = array;
        this.thread = thread;
        this.low = 0;
        this.high = array.length - 1;
        this.nThread=nThread;
    }

    private void sortConThread(int numeroThread, int inzio, int fine) {
		if(numeroThread>=2){
			int mezzo = partition(array,inzio,fine);
			Thread sinistra =new Thread(()->{
				sortConThread( numeroThread-1,inzio,mezzo);
			});
			Thread destra =new Thread(()->{
				sortConThread( numeroThread-1,mezzo,fine);
			});
			sinistra.start();
                        destra.start();
			
			try {
				sinistra.join();
                                destra.join();
			} catch (InterruptedException ex) {
			}
			
		}else{
			sort(array,inzio,fine);
		}
	}

	

    int partition(int arr[], int left, int right) {
        int i = left, j = right;
        int tmp;
        int pivot = arr[(left + right) / 2];

        while (i <= j) {
            while (arr[i] < pivot) {
                i++;
            }
            while (arr[j] > pivot) {
                j--;
            }
            if (i <= j) {
                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }
        };

        return i;
    }

    void sort(int[] array ,int left, int right) {
        int index = partition(array, left, right);
        if (left < index - 1) {
            sort(array, left, index - 1);
        }
        if (index < right) {
            sort(array, index, right);
        }
    }

    @Override
    public void run() {
        long tempo = getTimeSort();
        String tempoinsec = arrotondaPerDifetto((double) tempo / 1000000000);
        System.out.println("Tempo impiegato per il QuickSort: " + tempo + " nano secondi o circa " + tempoinsec + " secondi");
    }

    private long getTimeSort() {
        System.out.println("Inizio riordinamento array QuickSort...");
        long startTime = System.nanoTime();
        sortConThread(nThread, this.low, this.high);
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
