
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author giacomo
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Sort s=new Sort();
        int[] array= randomArray(10000,100);  //genero array con numeri speudocasuali
        System.out.println(Arrays.toString(array));
        System.out.println("");
        long startTime=System.nanoTime();
        s.sort(4, array, 0, array.length);     //12 numero massimo di thread che si possono instanziare  
        long time=System.nanoTime()- startTime;
        
        long milliSeconds=TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println("tempo utilizzato: "+milliSeconds+" Msec");
        System.out.println(Arrays.toString(array));
        
    }
    /**
     * metodo per creare array di numeri pseudocasuali 
     * @param length lunghezza dell'array che si vuole creare
     * @param max numero max che possono raggiungere gli int (0- max-1)
     * @return array con valori pseudocasuali
     */
    public static int[] randomArray(int length, int max){
        Random random=new Random();
    
        int[]array=new int[length];
        for (int i=0;i<array.length;i++){
            array[i]=random.nextInt(max);
        }
        return array;
}
}
