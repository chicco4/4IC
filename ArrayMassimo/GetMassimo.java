/**
 * Created by studente on 30/11/17.
 */
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

public class GetMassimo extends Thread{

    private int[] array;
    private int inizio,fine,Parti,Thread;
    private ArrayList<Integer> risultati=new ArrayList();
    private CountDownLatch cd;

    public GetMassimo(int[] array,int Thread){
        cd=new CountDownLatch(Thread);
        Parti=array.length/Thread;
        this.Thread=Thread;
        this.array=array;
    }

    public void run(){
        inizio=0;
        fine=0;
        for(int i=0;i<Thread;i++){
            fine+=Parti;
            Thread t=new
            ElementoMassimoArray(array,inizio,fine-1,risultati);
            inizio=fine;
            t.start();
            cd.countDown();
        }

        try{
            cd.await();
            int result=risultati.get(0);
            for(int i=0;i<risultati.size()-1;i++)
                if(risultati.get(i)>=result) result=risultati.get(i);
            System.out.println("MAX: "+result);
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}