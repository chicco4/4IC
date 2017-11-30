package maxarray;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
public class MaxArray{
    public static void main(String[] args){
        Random random = new Random();
        int[] array = new int[100];
        for(int i=0;i<array.length;i++)
            array[i] = random.nextInt(500)+1;
        System.out.println("Max:\t\t"+max(array, 5));
        System.out.println("Array ordinato:\n"+Arrays.toString(bubbleSort(array)));
    }
    static int[] massimi;
    static CountDownLatch l;
    static int max(int[] array, int numThread){
        //Per gestire la sincronia tra i thread che devono trovare il massimo
        //nella loro parte di array ed il thread main, che, tramite il metodo
        //"await" di un oggetto "CountDownLatch", attende il giusto momento
        l = new CountDownLatch(numThread);
        int temp = 0;
        int index = array.length/numThread;
        //Array che conterrà il massimo valore di ogni sub-array
        massimi = new int[numThread];
        //Per assegnare ad ogni thread la sua parte di array
        int[] subArray = new int[index];
        for(int i=0;i<numThread;i++){
            int lim = temp+index;
            if(array.length%numThread != 0 && i == numThread-1){
                subArray = new int[index+(array.length%numThread)];
                for(int j=0;temp<array.length;temp++,j++)
                    subArray[j] = array[temp];
            }else{
                for(int j=0;temp<lim;temp++,j++)
                    subArray[j] = array[temp];
            }
            new Thread(new SorterThread(subArray, i), "Thread_"+(i+1)).start();
            subArray = new int[index];
        }
        try{
            l.await();  //Procede solo quando tutti i thread hanno finito il loro lavoro
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }
        int max = massimi[0];
        for(int i=1;i<massimi.length;i++){
            if(max < massimi[i])
                max = massimi[i];
        }
        return max;
    }
    static class SorterThread implements Runnable{
        int[] array;
        int pos;
        public SorterThread(int[] array, int pos){
            this.array = array;
            this.pos = pos;
        }
        @Override
        public void run(){
            array = bubbleSort(array);
            int max = array[0];
            for(int i=1;i<array.length;i++)
                if(max < array[i])
                    max = array[i];
            massimi[pos] = max;
            System.out.println("Max "+Thread.currentThread().getName()+":\t"+max);
            l.countDown();
        }
    }
    //Ho scelto il "bubbleSort" com metodo di ordinamento, per comodità
    static int[] bubbleSort(int[] array){
        boolean iVeChanged = true;
        for(int i=array.length;i>0 && iVeChanged;i--){
            iVeChanged = false;
            for(int j=1;j<i;j++){
                if(array[j-1] > array[j]){
                    int temp = array[j-1];
                    array[j-1] = array[j];
                    array[j] = temp;
                    iVeChanged = true;
                }
            }
        }
        return array;
    }
}