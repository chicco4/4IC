package threadsort;

import java.util.Arrays;
import static java.util.Arrays.sort;

/**
 * @author Andrea Dattero
 */
public class ThreadSort {

    public static void main(String[] args) throws InterruptedException {
        int nElementi = 9999999, nMax = 100;
        int[] array = new int[nElementi];
        int[] array1 = new int[nElementi];
        int nThread = 7;
        for (int i = 0; i < nElementi; i++) {
            int caso = (int) (Math.random() * nMax);
            array[i] = caso;
            array1[i] = caso;
        }

        Ordina o = new Ordina(nThread);
        //System.out.println(Arrays.toString(array));
        long tempo = System.currentTimeMillis();
        o.ordina(array);
        //System.out.println(Arrays.toString(array));
        System.out.println("Ci ha messo : " + (System.currentTimeMillis() - tempo) + "ms con " + nThread + " thread");
        tempo = System.currentTimeMillis();
        sort(array1);
        //System.out.println(Arrays.toString(array));
        System.out.println("Ci ha messo : " + (System.currentTimeMillis() - tempo) + "ms con " + 1 + " thread");
    }

}
