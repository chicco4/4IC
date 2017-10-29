package threadsort;

import static java.util.Arrays.sort;

/**
 *
 * @author Andrea Dattero
 */
class Ordina {
    int  nThreads;
    public Ordina(int  nThreads) {
        this.nThreads=nThreads;
    }
    
    public void ordina(int[] array) throws InterruptedException {
        Thread ordina = new Thread(()->{
            this.ordinamento(this.nThreads, array, 0, array.length);
        });ordina.start();
        ordina.join();
    }
    
    private void ordinamento(int nThread,int[] array,int inizio,int fine){
        if(nThread>1){
            //separa
            int mezzo = separa(array,inizio,fine);
            Thread sinistra = new Thread(()->{
                ordinamento(nThread-1,array,inizio,mezzo);
            });
            Thread destro = new Thread(()->{
                ordinamento(nThread-1,array,mezzo,fine);
            });
            sinistra.start();destro.start();
            
            try {
                sinistra.join();destro.join();
            } catch (InterruptedException ex) {}
            
        }else{
            //ordina 
            sort(array,inizio,fine);
        }
    }
    
    int separa(int array[], int inizio, int fine) {
        int i = inizio, j = fine - 1;
        int valoreMezzo = array[(inizio + fine - 1) / 2];
        int temp;
        for (;i <= j;) {
            while (array[i] < valoreMezzo) {
                i++;
            }
            while (array[j] > valoreMezzo) {
                j--;
            }

            if (i <= j) {
                temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        };

        return i;
    }
    
}
