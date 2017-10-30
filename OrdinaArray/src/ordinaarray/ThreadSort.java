package ordinaarray;

/**
 *
 * @author federico.scaggiante
 */
public class ThreadSort extends Thread {
    private int[] vector;
    private int p,r;
    private Massimo max;
    ThreadSort(int [] v, int p, int r, Massimo m) {
        // inizializzazione dei parametri
        this.vector = v;
        this.p = p;
        this.r = r;
        this.max = m;
    }
    public void run() {
        // ordinamento del vettore
        // prima il partizionamento
        max.max(this.activeCount());
        if(p<r) {
            int pivot_i = Partition(vector,p,r);
            Thread primaparte =null, secondaparte=null;
                primaparte = new ThreadSort(vector,p,pivot_i,max);
                secondaparte = new ThreadSort(vector,(pivot_i+1),r,max);
                primaparte.start();
                secondaparte.start();
            try {
                    primaparte.join();
                    secondaparte.join();
            } catch (InterruptedException e) {}
        }
        return;
    }
    private int Partition(int[] vector, int p, int r) 
    {
        int pivot = vector[p];
        int i = (p-1);
        int j = (r+1);
        while(true) {
            do {
                j = j - 1; 
            } while(vector[j]>pivot);
            do {
                i = i + 1; 
            } while(vector[i]<pivot);
            if(i<j) {
                int temp = vector[i];
                vector[i] = vector[j];
                vector[j] = temp;
            } else {
                return(j);
            }
        }
    }
    public int[] getArr() {
        return vector;
    }    
}
