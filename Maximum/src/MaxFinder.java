import java.util.concurrent.CountDownLatch;

/**
 * Created by studente on 30/11/17.
 */
public class MaxFinder extends Thread{
    private int[] in;
    private int out;
    private int[] outs;
    private int begin;
    private int end;
    private CountDownLatch ctd;

    public MaxFinder(int[] in, int begin, int end, int out, int[] outs, CountDownLatch ctd){
        this.in = in;
        this.out = out;
        this. ctd = ctd;
        this.begin = begin;
        this.end = end;
        this.outs = outs;
    }

    public void run(){
        outs[out] = in[begin];
        for(int i = begin; i < end; i++)
            if(in[i] > outs[out])
                outs[out] = in[i];
        ctd.countDown();
    }
}
