/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordinamento;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author francesco.fortunato
 */
public class OrdinamentoThread implements Runnable {
	int[] subArray;
        int subArrayLength;
        static int parteDellArray = 0;
        int[] totalArray;
        int numThreads;
	public OrdinamentoThread(int[] a, int num) {
            totalArray = a;
            numThreads = num;
	}
	@Override
	public void run() { 
            if(parteDellArray < numThreads) {
                subArrayLength = totalArray.length / numThreads;
                subArray = new int[subArrayLength];
                for(int i = 0; i < subArrayLength; i++) {
                    subArray[i] = totalArray[i + subArrayLength * parteDellArray];
                }
                parteDellArray++;
            } else {
                subArrayLength = totalArray.length / numThreads + totalArray.length % numThreads;
                subArray = new int[subArrayLength];
                for(int i = 0; i < subArray.length; i++) {
                    subArray[i] = totalArray[i + subArrayLength * (parteDellArray - 1)];
                }
                parteDellArray++;
            }
            QuickSort.sort(subArray);
            finalSort(subArray);
	}
        protected static void finalSort(int[] t) {
            for (int i = 0; i < t.length; i++) {
                Sort.array[Sort.index++] = t[i];
                for (int j = 0; j < Sort.index - 1; j++) {
                    if (Sort.array[Sort.index - 1] < Sort.array[j]) {
                        for (int k = Sort.index - 1; k > j; k--) {
                            int temp = Sort.array[k];
                            Sort.array[k] = Sort.array[k - 1];
                            Sort.array[k - 1] = temp;
                        }
                        break;
                    }
                }
            }
    }
}
