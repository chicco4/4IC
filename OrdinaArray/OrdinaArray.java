/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordinaarray;
import java.util.Random;
/**
 *
 * @author Marco
 */
public class OrdinaArray {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MergeSort sort1=new MergeSort();
        long time;
        double tempoImpiegato;
        int[] a=generaNumeri(10000, 8000);
        
        System.out.print("Array disordinato: ");
        stampaNumeri(a);
        time=System.nanoTime();
        int[] b=sort1.mergeSortMultithreading(a);
        tempoImpiegato=(System.nanoTime()-time)/1000000.0;
        System.out.print("Array ordinato: ");
        stampaNumeri(b);
        System.out.println("Merge sort con più thread impiega: "+tempoImpiegato+"ms");
        System.out.println("");
        
        System.out.print("Array disordinato: ");
        stampaNumeri(a);
        time=System.nanoTime();
        sort1.mergeSortSingleThread(a);
        tempoImpiegato=(System.nanoTime()-time)/1000000.0;
        System.out.print("Array ordinato: ");
        stampaNumeri(a);
        System.out.println("Merge sort con un solo thread impiega: "+tempoImpiegato+"ms");
        System.out.println("");
    }
    
    public static int[] generaNumeri(int n, int max){
        int[] array = new int[n];
        Random r = new Random();
        for(int i = 0; i < array.length; i++){
            array[i] = r.nextInt(max);
        }
        return array;
    }
    public static void stampaNumeri(int[] array){
        for (int i=0; i<array.length; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println("");
    }
}
