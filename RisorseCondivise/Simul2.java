import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Simul2 {

    public static void main(String[] args) {
        final int nRisorse = 2;
        final int nThread = 2;
        
        Risorsa[] r = new Risorsa[nRisorse];
        Thread[] t = new Thread[nThread];
         
        for(int i=0; i<r.length; i++){
            String s = "" + (char)i;
            r[i] = new Risorsa(s);
        }
        
        for(int i=0; i<t.length; i++){
            t[i] = new Thread(new Task(r, i));
            try{
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException ex) {
            }
            t[i].start();
        }
     
        try{
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException ex) {
        }
        
        System.out.println("Interrompo");
        
        for(int i=0; i<t.length; i++){
            t[i].interrupt();
        }
    }
}
