/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordinamentoprova;
import java.text.DecimalFormat;

/**
 *
 * @author matteo
 */
public class MergeSort extends Thread {

    private final int[] array;
    private final Thread thread;
    /**
     * 
     * @param array Array da ordinare
     * @param thread Thread da far runnare il sort
     */
    public MergeSort(int[] array, Thread thread) {
        this.array = array;
        this.thread = thread;
    }
    //
    private void mergeSort(int[] a, int[] vectorTemp, int left, int right) {
        if (left < right) {
            int center = (left + right) / 2;
            mergeSort(a, vectorTemp, left, center);
            mergeSort(a, vectorTemp, center + 1, right);
            merge(a, vectorTemp, left, center + 1, right);
        }
    }

    public void sort() {
        int vectorTemp[];
        vectorTemp = new int[array.length];
        mergeSort(array, vectorTemp, 0, array.length - 1);
    }

    private void merge(int[] a, int[] vectorAux, int posLeft, int posRight, int posEnd) {
        int endLeft = posRight - 1;
        int posAux = posLeft;
        int numElemen = posEnd - posLeft + 1;

        while (posLeft <= endLeft && posRight <= posEnd) {
            if ((a[posLeft]) < (a[posRight])) {
                vectorAux[posAux++] = a[posLeft++];
            } else {
                vectorAux[posAux++] = a[posRight++];
            }
        }

        while (posLeft <= endLeft) {
            vectorAux[posAux++] = a[posLeft++];
        }

        while (posRight <= posEnd) {
            vectorAux[posAux++] = a[posRight++];
        }

        for (int i = 0; i < numElemen; i++, posEnd--) {
            a[posEnd] = vectorAux[posEnd];
        }
    }
    //Metodo per far startare il thread
    public void run() {
        long tempo = getTimeSort();
        String tempoinsec=arrotondaPerDifetto((double)tempo/1000000000);
        System.out.println("Tempo impiegato per il MergeSort: " + tempo + " nano secondi o circa " + tempoinsec + " secondi");
    }
    //Restituisce il tempo di ordinamento dell'array
    private long getTimeSort() {
        System.out.println("Inizio riordinamento array MergeSort...");
        long startTime = System.nanoTime();
        sort();
        System.out.println("Fine riordinamento array SelectionSort...");
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

        return  df.format(value);
    }
}
