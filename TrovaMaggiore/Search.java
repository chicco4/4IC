import java.util.concurrent.CountDownLatch;

/**
 * Created by studente on 30/11/17.
 */
public class Search {
    int[] array= new int[100];
    int inizio;
    final int ALL_THREADS = 10;
    int[] results = new int[ALL_THREADS];
    int chunkSize = array.length / ALL_THREADS;


    public int[] riempi(int array[]) {
        for (int i = 0; i < array.length; i++){
            int random= (int) (Math.random()*100);
            array[i]=random;
        }
        return array;
    }

    public int searchMaxValue(int[] array) throws InterruptedException {
        CountDownLatch end = new CountDownLatch(ALL_THREADS);
        for (int i = 0; i <ALL_THREADS; i++) {
            int sentinella = i;
            new Thread( () -> {
                int max = -1;
                inizio = sentinella * chunkSize;
                for (int j = inizio; j < inizio + chunkSize && j < array.length; j++) {
                    if (max == -1 || max <  array[j]) {
                        max = array[j];
                    }
                }
                results[sentinella] = max;
                end.countDown();
            }
            ).start();
        }
        end.await();
        int max = results[0];
        for (int k = 1; k < results.length; k++) {
            if (max < results[k]) {
                max = results[k];
            }
        }
        System.out.printf("Max found %d%n", max);
        return max;
    }
}