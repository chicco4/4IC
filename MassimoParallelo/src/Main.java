import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class Main {
    public static final int NUMERO_THREAD = 10;
    public static final int DIMENSIONE_ARRAY = 100;
    public static final int MINIMO = 0;
    public static final int MASSIMO = Integer.MAX_VALUE-1;
    public static void main(String[] args) throws InterruptedException {
        int massimo;
        CountDownLatch cdl;
        int[] array;
        //Integer[] massimi;
        int [] massimi;

        array = arrayRandom(DIMENSIONE_ARRAY, MINIMO, MASSIMO);
        cdl = new CountDownLatch(NUMERO_THREAD);
        //massimi = new Integer[NUMERO_THREAD];
        //for(int i=0; i<NUMERO_THREAD; i++) massimi[i] = new Integer(0);
        massimi = new int[NUMERO_THREAD];

        System.out.println("Array: " + Arrays.toString(array));

        for(int i=0; i<NUMERO_THREAD; i++){
            //(new Thread(new MaxFinder(array, DIMENSIONE_ARRAY/NUMERO_THREAD * i, DIMENSIONE_ARRAY/NUMERO_THREAD * (i+1), cdl, massimi[i]))).start();
            (new Thread(new MaxFinder(array, DIMENSIONE_ARRAY/NUMERO_THREAD * i, DIMENSIONE_ARRAY/NUMERO_THREAD * (i+1), cdl, massimi, i))).start();
        }

        cdl.await();

        massimo = array[0];
        for(int i=0; i<NUMERO_THREAD; i++)
            if(massimo < massimi[i]) massimo = massimi[i];

        System.out.println("Massimi: " + Arrays.toString(massimi));

        System.out.println("Massimo: " + massimo);
    }
    public static int[] arrayRandom(int length, int min, int max) {
        Random generatore = new Random(System.currentTimeMillis());
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = generatore.nextInt(max+1 - min) + min;
        }
        return array;
    }
}
