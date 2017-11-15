package risorsecondivise;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author federico.scaggiante
 */
public class Task implements Runnable{
    Risorsa risorsa;
    Risorsa risorsa1;
    Risorsa risorsa2;
    String name;
    public Task(String name,Risorsa risorsa1,Risorsa risorsa2){
        this.name=name;
        this.risorsa1=risorsa1;
        this.risorsa2=risorsa2;
    }
    public Task(String name,Risorsa risorsa) {
        this.risorsa = risorsa;
        this.name = name;
    }
    
    @Override
    public void run() {
        if(risorsa2==null){
            for(int i=0;i<1;i++){
                try {
                    System.out.println(this.name+" sta provando ad acquisire "+risorsa.getName());
                    TimeUnit.SECONDS.sleep(2);
                    risorsa.semaphore.acquire();
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println(this.name+" ha acquisito "+risorsa.getName());
                    
                    System.out.println(this.name+" sta usando "+risorsa.getName());
                    TimeUnit.SECONDS.sleep(4);
                    
                    risorsa.semaphore.release();
                    System.out.println(this.name+" ha rilasciato "+risorsa.getName());
                } catch (InterruptedException ex) {
                    System.out.println(this.name+ " è terminato");
                }
            }
        }else{
            for(int i=0;i<1;i++){
            try {
                System.out.println(this.name+" sta provando ad acquisire "+risorsa1.getName());
                TimeUnit.SECONDS.sleep(2);
                risorsa1.semaphore.acquire();
                TimeUnit.SECONDS.sleep(2);
                System.out.println(this.name+" ha acquisito "+risorsa1.getName());
                
                System.out.println(this.name+" sta provando ad acquisire "+risorsa2.getName());
                TimeUnit.SECONDS.sleep(2);
                risorsa2.semaphore.acquire();
                TimeUnit.SECONDS.sleep(2);
                System.out.println(this.name+" ha acquisito "+risorsa2.getName());
                
                System.out.println(this.name+" sta usando "+risorsa1.getName()+" & "+risorsa2.getName());
                TimeUnit.SECONDS.sleep(4);
                
                risorsa1.semaphore.release();
                System.out.println(this.name+" ha rilasciato "+risorsa1.getName());
                
                risorsa2.semaphore.release();
                System.out.println(this.name+" ha rilasciato "+risorsa2.getName());
            } catch (InterruptedException ex) {
                System.out.println(this.name+ " è terminato");
            }
        }
        }
        System.out.println(this.name+ " è terminato bene");
    } 
}

