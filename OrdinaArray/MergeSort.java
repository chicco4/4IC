/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordinaarray;

/**
 *
 * @author Marco
 */
public class MergeSort {
    //Ordinamento con un solo thread
    public void mergeSortSingleThread(int[] array) {
        int temp []=temp=new int [array.length];
        dimezzaMergeSort(array, temp, 0, array.length-1);
    }
    private void dimezzaMergeSort(int[] array, int[] arrayTemp, int sinistra, int destra) {
        if(sinistra<destra) {
            int centro=(sinistra+destra)/2;
            dimezzaMergeSort(array, arrayTemp, sinistra, centro);
            dimezzaMergeSort(array, arrayTemp, centro+1, destra);
            merge(array, arrayTemp, sinistra, centro+1, destra);
        }
    }
    private void merge(int[] array, int[] arrayAux, int sinistra, int destra, int fine) {
        int d=destra-1;
        int s=sinistra;
        int num=fine-sinistra+1;
        while(sinistra<=d && destra<=fine) {
            if(array[sinistra]<array[destra])
                arrayAux[s++]=array[sinistra++];
            else
                arrayAux[s++]=array[destra++];
        }
        while(sinistra<=d) {
            arrayAux[s++]=array[sinistra++];
        }
        while(destra<=fine) {
            arrayAux[s++]=array[destra++];
        }
        for(int i=0; i<num; i++) {
            array[fine]=arrayAux[fine];
            fine--;
        }
    }
    
    //Ordinamento con più thread
    public int[] mergeSortMultithreading(int[] array){
        int[] copia=new int[array.length];
        int[] finale=new int[array.length];
        for(int i = 0; i<array.length; i++) {
            copia[i]=array[i];
            finale[i]=array[i];
        }
        Thread t1=new Thread(() -> { dimezzaMergeSort2(finale, 0, array.length/2, copia);});
        t1.start();
        dimezzaMergeSort2(finale, array.length/2, array.length, copia);
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        merge2(copia, finale, 0, array.length/2, array.length);
        return finale;
    }
    private void dimezzaMergeSort2(int[] array2, int sinistra, int destra, int[] array) {
        if(destra-sinistra<2) {
            return;
        }
        int centro=(destra+sinistra)/2;
        dimezzaMergeSort2(array, sinistra, centro, array2);
        dimezzaMergeSort2(array, centro, destra, array2);
        merge2(array2, array, sinistra, centro, destra);
    }
    private void merge2(int[] array, int[] finale, int sinistra, int centro, int destra) {
        int k=sinistra;
        int j=centro;
        for(int i=sinistra; i<destra; i++) {
            if(k<centro && (j>=destra || array[k]<=array[j])) {
                finale[i]=array[k];
                k++;
            } else {
                finale[i]=array[j];
                j=j+1;
            }
        }
    }
}
