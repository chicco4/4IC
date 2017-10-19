package test;

import java.util.concurrent.TimeUnit;

/**
 *
 * @author giacomo.ravagnan
 */
public class test1 {
    public static void main(String[] args) {
        Risorsa risorsa=new Risorsa("risorsa");
        Thread t1 = new Thread(new Task(risorsa));
        Thread t2 = new Thread(new Task(risorsa));
        t1.start();
        t2.start();
        try{
            TimeUnit.SECONDS.sleep(20);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
        t1.interrupt();
        t2.interrupt();
    }
    
}
