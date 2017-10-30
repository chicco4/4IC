import java.util.Random;
public class Test{
public static void main(String[] args) {
        Random random=new Random();
        int arr[] =new int[1000] ;
        for(int i=0;i<arr.length;i++){
            arr[i]=random.nextInt();
        }
        double startTime=System.currentTimeMillis();
        Ordinamento mr = new Ordinamento(arr,0,arr.length-1);
        Thread t = new Thread(mr);
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        double stopTime=System.currentTimeMillis();
        System.out.println("Tempo: "+(stopTime-startTime)+" ms");

    }
 }
