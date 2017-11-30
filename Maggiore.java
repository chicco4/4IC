import java.util.concurrent.CountDownLatch;

/**
 * Created by studente on 30/11/17.
 */
public class Maggiore implements Runnable{

    private int[] list;
    private int threadN;
    private int[] result;
    private CountDownLatch c;

    Maggiore(int threadN, int[]result, CountDownLatch c, int[] arg, int bottomIndex, int topIndex){
        this.list = new int[topIndex-bottomIndex];
        for(int i=0; i<this.list.length; i++){
            this.list[i]= arg[i+bottomIndex];
        }
        this.threadN= threadN;
        this.result = result;
        this.c = c;
    }

    @Override
    public void run() {
        for(int i=0; i<this.list.length; i++){
            if(this.list[i]>result[threadN]){
                result[threadN]= this.list[i];
            }
        }
        c.countDown();
    }
}
