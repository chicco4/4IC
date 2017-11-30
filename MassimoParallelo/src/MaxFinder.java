import java.util.concurrent.CountDownLatch;

/**
 * Created by studente on 30/11/17.
 */
public class MaxFinder implements Runnable{
    private int[] array;
    private int inizio;
    private int fine;
    private CountDownLatch cdl;
    //private Integer massimo;
    private int[] massimo;
    private int indice;

    /*public MaxFinder(int[] array, int inizio, int fine, CountDownLatch cdl, Integer massimo) {
        this.array = array;
        this.inizio = inizio;
        this.fine = fine;
        this.cdl = cdl;
        this.massimo = massimo;
    }*/
    public MaxFinder(int[] array, int inizio, int fine, CountDownLatch cdl, int[] massimo, int indice) {
        this.array = array;
        this.inizio = inizio;
        this.fine = fine;
        this.cdl = cdl;
        this.massimo = massimo;
        this.indice = indice;
    }

    /*@Override
    public void run() {
        massimo = array[inizio];
        for(int i=inizio; i<fine; i++)
            if(massimo<array[i]) massimo = array[i];
        System.out.println("Massimo da un thread: " + massimo);
        cdl.countDown();
    }*/
    public void run() {
        massimo[indice] = array[inizio];
        for(int i=inizio; i<fine; i++)
            if(massimo[indice]<array[i]) massimo[indice] = array[i];
        System.out.println("Massimo dal thread " + indice +": " + massimo[indice]);
        cdl.countDown();
    }
}
