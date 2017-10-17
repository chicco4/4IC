import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.Random;

public class Task implements Runnable{
   
    private Semaphore semaforo;
    private Risorsa ris1;
    private Risorsa ris2;
    
    public Task(Risorsa ris){
        this.ris1 = ris;
    }

    public Task(Risorsa ris1, Risorsa ris2){
        this.ris1 = ris1;
        this.ris2 = ris2;
    }
    
    @Override
    public void run(){
        try{
            //TimeUnit.SECONDS.sleep(new Random().nextInt(5));
            if(ris2 == null){               
                ris1.semaforo.acquire();
                
                for(int i = 0; i < new Random().nextInt(10); i++){
                    System.out.println(Thread.currentThread().getName() + ": Sto utilizzando " + ris1.nome + " da " + i + "secondi.");
                    TimeUnit.SECONDS.sleep(1);
                }
                ris1.semaforo.release();
                System.out.println(Thread.currentThread().getName() + ": ho finito di utilizzare " + ris1.nome);           
            }else{
                ris1.semaforo.acquire();
                ris2.semaforo.acquire();
                
                for(int i = 0; i < new Random().nextInt(10); i++){
                    System.out.println(Thread.currentThread().getName() + ": Sto utilizzando " + ris1.nome + " e " + ris2.nome +" da " + i + "secondi.");
                    TimeUnit.SECONDS.sleep(1);
                }
                ris1.semaforo.release();
                ris2.semaforo.release();
                System.out.println(Thread.currentThread().getName() + ": ho finito di utilizzare " + ris1.nome +" e " + ris2.nome);                
            }
        }catch(InterruptedException e){
            System.out.println(Thread.currentThread().getName() + "si è interrotto.");
        }
    }
}
