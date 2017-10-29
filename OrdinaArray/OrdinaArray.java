package ordinathread;

import java.util.Arrays;

public class OrdinaArray {

    public static void main(String[] args) throws InterruptedException {
        Ordinamento ordina = new Ordinamento();
        int[] a = new int[10];
        
        for(int i = 0; i< a.length; i++)
            a[i] = (int) (Math.random()*10);
        
        int[] b = a.clone();
        System.out.println("Array random non in ordine: " + Arrays.toString(a));

        long currentTime1 = System.nanoTime();
        int threadsNum = 10;
        ordina.threadSorting(a, threadsNum);
        System.out.println("Array random ordinato in " + (System.nanoTime()-currentTime1)
                + " nanosecondi con " + threadsNum+ " thread: " + Arrays.toString(a));
        
        long currentTime2 = System.nanoTime();
        ordina.threadSorting(b, 1);
        System.out.println("Stesso array ordinato in " + (System.nanoTime()-currentTime2)
                + " nanosecondi con 1 thread: " + Arrays.toString(a));         
    }
    
}
