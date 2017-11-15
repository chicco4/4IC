package risorsecondivise;

import java.util.concurrent.Semaphore;

/**
 *
 * @author ilbos
 */
public class Risorsa {
    Semaphore tlight;
    String name;
    public Risorsa(String name) {
        this.name = name;
        this.tlight=new Semaphore(1,true);
    }
    public String getName(){
        return name;
    }
}
