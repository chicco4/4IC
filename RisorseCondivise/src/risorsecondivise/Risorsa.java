package risorsecondivise;

import java.util.concurrent.Semaphore;

/**
 *
 * @author ilbos
 */
public class Risorsa {
    Semaphore semaphore;
    String name;
    public Risorsa(String name) {
        this.name = name;
        this.semaphore=new Semaphore(1,true);
    }
    public String getName(){
        return name;
    }
}
