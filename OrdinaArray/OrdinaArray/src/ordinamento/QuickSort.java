/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordinamento;

/**
 *
 * @author FortuF100
 */
public class QuickSort {
    private static int[] values;
    public static void sort(int[] v) {
        values = v;
        if (values ==null || values.length==0){
            return;
        }
        quicksort(0, values.length - 1);
    }

    private static void quicksort(int low, int high) {
        int i = low, j = high;
        int pivot = values[low + (high-low)/2];
        while (i <= j) {
            while (values[i] < pivot) {
                i++;
            }
            while (values[j] > pivot) {
                j--;
            }
            if (i <= j) {
                exchange(i, j);
                i++;
                j--;
            }
        }
        if (low < j)
            quicksort(low, j);
        if (i < high)
            quicksort(i, high);
    }

    private static void exchange(int i, int j) {
        int temp = values[i];
        values[i] = values[j];
        values[j] = temp;
    }
}

