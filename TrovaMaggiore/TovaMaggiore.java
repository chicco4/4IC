import java.util.Date;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * Created by studente on 30/11/17.
 */
public class TovaMaggiore {
    public static void main(String[] args) throws InterruptedException {
        Search finder=new Search();
        int[] array = finder.riempi(new int[10]);
        finder.searchMaxValue(array);
    }
}