/**
 * Created by studente on 30/11/17.
 */


import java.util.Random;

public class Max{
    public static void main(String[] args){

        final int MAX=1000;
        int[] array=new int[MAX];

        Random rnd=new Random();

        for(int i=0;i<array.length;i++){
            array[i]=rnd.nextInt(1000);
            System.out.println(array[i]);
        }

        Thread t=new GetMassimo(array,20);
        t.start();

    }
}
