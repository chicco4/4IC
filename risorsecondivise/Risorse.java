package risorsecondivise;

import java.util.concurrent.Semaphore;


/**
 *
 * @author Andrea Dattero
 */
public class Risorse {
    Semaphore s;
    String nome;
    Risorse(String nome){
        this.s=new Semaphore(1);
        this.nome=nome;
    }
    public Semaphore getSemaphore(){
        return this.s;
    }
    public String getName(){
        return this.nome;
    }
}
