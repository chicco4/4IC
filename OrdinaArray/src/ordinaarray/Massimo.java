package ordinaarray;

/**
 *
 * @author federico.scaggiante
 */
public class Massimo {
    int max;
    Massimo() {
        max = 0;
    }
    public synchronized void max(int n) {
        if(n>max) 
            max = n;
    }
    public synchronized int get() {
        return(max);
    }
}
