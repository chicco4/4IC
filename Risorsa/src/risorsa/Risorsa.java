package risorsa;

import java.util.concurrent.Semaphore;

public class Risorsa {

    Semaphore semaforo;
    private String r;

    Risorsa(String r) {
        semaforo = new Semaphore(1, true);
        this.r = r;
    }

    public Risorsa(Semaphore s, String r) {
        this.semaforo = s;
        this.r = r;
    }

    public String getRisorsa() {
        return r;
    }
}
