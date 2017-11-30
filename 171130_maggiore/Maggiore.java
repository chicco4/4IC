import java.util.concurrent.CountDownLatch;

/**
 * Created by studente on 30/11/17.
 */
public class Maggiore implements Runnable{

    //parte di array da esaminare dal thread
    private int[] list;
    //numero del thread
    private int threadNumber;
    //riferimento all'array dei risultati dei vari thread
    private int[] result;
    //riferimento al countdownlatch
    private CountDownLatch c;

    //costruttore
    Maggiore(int threadNumber, int[]result, CountDownLatch c, int[] arg, int bottomIndex, int topIndex){
        this.list = new int[topIndex-bottomIndex];
        for(int i=0; i<this.list.length; i++){
            this.list[i]= arg[i+bottomIndex];
        }
        this.threadNumber= threadNumber;
        this.result = result;
        this.c = c;
    }

    @Override
    public void run() {
        for(int i=0; i<this.list.length; i++){
            if(this.list[i]>result[threadNumber]){
                result[threadNumber]= this.list[i];
            }
        }
        //comunica al count down latch che ha finito
        c.countDown();
    }
}
