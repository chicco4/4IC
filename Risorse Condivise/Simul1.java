/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package risorsecondivise;
import java.util.concurrent.TimeUnit;
/**
 *
 * @author feder
 */
public class Simul1 {
    public static void main(String[] args) {
        Risorse r1 = new Risorse("risorsa 1");
        Thread t1 = new Thread(new Task(r1));
        Thread t2 = new Thread(new Task(r1));
        t1.setName("t1");
        t2.setName("t2");
        t1.start();
        t2.start();
        try{
            TimeUnit.SECONDS.sleep(10);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
        t1.interrupt();
        t2.interrupt();
    }
    }
