import java.lang.reflect.Array;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * Created by studente on 30/11/17.
 */
public class Main {
    static Random r=new Random();
    public static void main(String[] args) throws InterruptedException {
        int[] array=new int[100]; // lunghezza predefinita

        array=generaCasuale(100, array); //generato array con numeri casuale
        System.out.println();
        for(int j=0;j<array.length; j++){
            System.out.print(array[j]+" , ");
        }

        CountDownLatch cdl=new CountDownLatch(5);

        int posIn=0;
        int blocco= array.length/5;
        int posFin=posIn+blocco;
        Thread t;
        int contThread=0;

        for(int i=0;i<5;i++){
            t=new massimo(posIn,posFin,array,contThread);
            t.start();
            posIn+=blocco;
            posFin+=blocco;
        }
        try{
            cdl.await();
        }catch (Exception e){
            System.out.println("errore");
        }
        }



    public static int[] generaCasuale(int max, int[] array){
        int[] temp=new int[array.length];
        for (int i = 0; i < array.length; i++) {
            temp[i] = r.nextInt(max);
        }
        return temp;
    }
}