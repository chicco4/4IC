package RisorseCondivise;

import java.util.concurrent.Semaphore;
/**
 *
 * @author federico.scaggiante
 */

public class Risorsa {
    public Semaphore semaforo;
    private String nome;
    public Risorsa (String name){
        this.nome = name;
        this.semaforo = new Semaphore(1, true);
    }
    public String getName(){
        return nome;
    }
}
