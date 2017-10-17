import java.util.concurrent.Semaphore;

public class Risorsa {
    
    public Semaphore semaforo;
    public String nome;
    
    public Risorsa(String nome){
        this.nome = nome;
        this.semaforo = new Semaphore(1, true);
    }
    
}
