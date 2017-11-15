package risorsecondivise;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author federico.scaggiante
 */
public class Simul3 {
    public static void main(String[] args) {
        Risorsa r1=new Risorsa("R1");
        Risorsa r2=new Risorsa("R2");
        Thread t1=new Thread(new Task("A",r1,r2));
        Thread t2=new Thread(new Task("B",r2,r1));
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Simul1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
