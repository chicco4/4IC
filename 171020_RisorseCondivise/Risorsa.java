import java.util.concurrent.Semaphore;

public class Risorsa {
    protected Semaphore semaforo;
    private String nome;

    public Risorsa (String nome){
        this.nome = nome;
        this.semaforo = new Semaphore(1, true);
    }

    public String getName(){
        return nome;
    }

}
