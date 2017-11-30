import java.util.concurrent.CountDownLatch;

/**
 * Created by studente on 30/11/17.
 */
public class test {

    public static void main(String[] args) {

        //numero di thread
        final int N = 10;
        //dimensione dell'array random
        final int DIMENSIONE= 1000;
        //array di numeri random
        int[] array = new int[1000];
        for(int i = 0; i <  array.length; i++) {
            array[i] = (int) (Math.random() * 1000);
        }

        //array coi risultati dei thread
        int[] result = new int[N];

        //creo il count down latch
        CountDownLatch c = new CountDownLatch(N);

        //creo e starto i vari thread
        for(int i=0; i<N; i++){
            Maggiore m = new Maggiore(i, result, c, array, (DIMENSIONE/N)*i, (DIMENSIONE/N)*(i+1));
            Thread t = new Thread(m);
            t.start();
        }

        //il count down latch aspetta che tutti i thread abbiano finito (fatto countdown)
        try {
            c.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //printa il maggiore dei risultati di ogni thread
        int r=0;
        for (int i =0; i<N; i++){
            if(result[i] > r){
                r= result[i];
            }
        }
        System.out.println("il massimo è " + r);
    }
}
