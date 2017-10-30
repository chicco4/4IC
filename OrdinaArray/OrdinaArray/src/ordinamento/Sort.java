/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordinamento;

import java.util.Arrays;

/**
 *
 * @author FortuF100
 */
public class Sort {
    static int[] array;
    private static Thread[] threads;
    protected static int index = 0;
    public static int[] sort(int[] a, int numThreads) throws InterruptedException {
        threads = new Thread[numThreads];
        array = new int[a.length];
        for(int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new OrdinamentoThread(a,numThreads));
            threads[i].start();
            threads[i].join();
        }
        return array;
    }
    public static int quantiThread() {
        return threads.length;
    }

}
