/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordinamento;

/**
 *
 * @author francesco.fortunato
 */
public class MergeSort {
	private int[] array;
	public MergeSort(int[] a) {
		array = a;
	}
	public static void mergeSort(int[] a, int l, int r) {
		if(l < r) {
                    int middle = (l + r) / 2;
                    mergeSort(a,l,middle);
                    mergeSort(a,middle + 1,r);
                    merge(a,l,middle,r);
                }
	}
	public static void merge(int[] a, int start, int centre, int end) {
		int lungh1 = centre - start + 1;
		int lungh2 = end - centre;
		int[] firstHalf = new int[lungh1];
		int[] secondHalf = new int[lungh2];
		for(int i = 0; i < lungh1; i++) {
			firstHalf[i] = a[start + i];
		}
		for(int i = 0; i < lungh2; i++) {
			secondHalf[i] = a[centre + i + 1];
		}
		int in1 = 0, in2 = 0;
		int k = start;
		while(in1 < lungh1 && in2 < lungh2) {
			if(firstHalf[in1] <= secondHalf[in2]) {
				a[k] = firstHalf[in1];
				in1++;
			} else {
				a[k] = secondHalf[in2];
				in2++;
			}
			k++;
		}
		while(in1 < lungh1) {
			a[k] = firstHalf[in1];
			in1++;
			k++;
		}
		while(in2 < lungh2) {
			a[k] = secondHalf[in2];
			in2++;
			k++;
		}
	}
}
