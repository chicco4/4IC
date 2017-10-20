import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Simul1 {

    public static void main(String[] args) {
	final int nRisorse = 1;
        final int nThread = 2;
        
        Risorsa[] r = new Risorsa[nRisorse];
        Thread[] t = new Thread[nThread];
         
        for(int i=0; i<r.length; i++){
            String s = "" + (char)i;
            r[i] = new Risorsa(s);
        }
        
        for(int i=0; i<t.length; i++){
            t[i] = new Thread(new Task(r, i));
            t[i].start();
        }
     
        try{
            TimeUnit.SECONDS.sleep(15);
        } catch (InterruptedException ex) {
        }
        
        for(int i=0; i<t.length; i++){
            t[i].interrupt();
        }
    }
}
