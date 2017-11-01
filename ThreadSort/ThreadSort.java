package threadsort;

import java.util.Arrays;

/**
 *
 * @author luca.daminato
 */
public class ThreadSort {

    public static void main(String[] args) throws InterruptedException {
        int l1 = 100000, l2 = 100000000;
        int[] a = new int[l1];
        int[] b = new int[l1];
        int[] c = new int[l2];
        int[] d = new int[l2];

        for (int i = 0; i < a.length; i++) {
            a[i] = (int) (Math.random() * l1);
            b[i] = a[i];
        }
        for (int i = 0; i < c.length; i++) {
            c[i] = (int) (Math.random() * l2);
            d[i] = c[i];
        }

        //MergeSort Normale
        long tempoIniziale = System.nanoTime();
        MergeSort.mergeSort(a, 0, a.length-1);
        System.out.println("Tempo MergeSort lineare:\t" + (System.nanoTime() - tempoIniziale));

        //MergeSort Thread
        tempoIniziale = System.nanoTime();
        Thread t = new MergeSortThread(b, 0, b.length-1, 3);
        t.start();
        t.join();
        System.out.println("Tempo MergeSort con Thread:\t" + (System.nanoTime() - tempoIniziale));

        //QuickSort Normale
        tempoIniziale = System.nanoTime();
        QuickSort.quickSort(c, 0, c.length-1);
        System.out.println("Tempo QuickSort lineare:\t" + (System.nanoTime() - tempoIniziale));

        //QuickSort Thread
        tempoIniziale = System.nanoTime();
        t = new QuickSortThread(d, 0, d.length-1, 6);
        t.start();
        t.join();
        System.out.println("Tempo QuickSort con Thread:\t" + (System.nanoTime() - tempoIniziale));
    }

}
