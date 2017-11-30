import java.util.concurrent.CountDownLatch;

/**
 * Created by studente on 30/11/17.
 */
public class massimo extends Thread{
    int[] array;

    int posI, posF;

    public massimo(int posI, int posF, int[] array, int contMax) throws InterruptedException {
        this.array=array.clone();
        this.posI=posI;
        this.posF=posF;
        }


    @Override
    public void run() {
        int valMax=0;
        for(int i=posI; i<posF;i++){
          if(array[i]>valMax){
              valMax=array[i];
          }
        }
        System.out.println(valMax);
    }
}

