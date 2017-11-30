import java.util.Date;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * Created by studente on 30/11/17.
 */
public class TestMaxFinder {
    public static void main(String[] args) {
        final int LEN = 10000;
        CountDownLatch ctd = new CountDownLatch(LEN/100);
        Random rnd = new Random(new Date().getTime());
        int[] maxs = new int[LEN/100];
        int[] random = new int[LEN];
        for(int i = 0; i < random.length; i++)
            random[i] = rnd.nextInt();
        Thread[] finders = new Thread[LEN/100];
        for(int i = 0; i < finders.length; i++) {
            finders[i] = new Thread(new MaxFinder(random, i * 100, i * 100 + 100, i, maxs, ctd));
            finders[i].start();
        }
        try {
            ctd.await();
        } catch (InterruptedException ie){
            ie.printStackTrace();
        }
        for (int m:maxs) {
            System.out.print(m + " ");
        }
        int max = maxs[0];
        for(int i = 0; i < maxs.length; i++)
            if(maxs[i] > max)
                max = maxs[i];
        System.out.println("\nAnd the Oscar for the maximum number goes to..... " + max);
    }
}
