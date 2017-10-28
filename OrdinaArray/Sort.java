

/**
 *
 * @author giacomo
 */
public class Sort {
    
    
    /**
     * questo metodo ha due funzioni:
     *  dividere i valori dell'array in base al valore della posizione media dell'array
     *  returna la posizione media per la divisione ricorsiva del programma
     * @param array array che si vuole ordinare
     * @param startP posizione iniziale dell'array
     * @param endP  posizione finale dell'array
     * @return posizione media dell'array
     * 
     */
   public int halfSort(int array[], int startP, int endP) {
        int pI = startP, pF = endP - 1;
        
        int midValue = array[(pI + pF) / 2];
       // System.out.println(Arrays.toString(array));
        while (pI <= pF) {
            while (array[pI] < midValue) {
                pI++;    
            }
            while (array[pF] > midValue) {
                pF--;    
            }

            if (pI <= pF) {
                swap(array,pI,pF);
                pI++;
                pF--;
            }
        }
        return pI;
    }
   /**
    * metodo generalizzato per diminuire righe di codice
    * @param array array di cui scambiare i valori 
     * @param pos1 posizione del primo valore da scambiare
     * @param pos2 posizione del secondo valore da scambiare
    */
   public void swap(int array[],int pos1, int pos2){
                 int temp = array[pos1];
                array[pos1] = array[pos2];
                array[pos2] = temp;
   }
   
   /**
    * metodo ricorsivo che crea due rami dell'array originale fino ad arrivare al numero di thread indicati
    * per poi ordinare ogni piccola porzione con il bubble sort
    * @param threads numero di thread per ordinare l'array
    * @param array array da dividere
    * @param start posizione iniziale per la suddivisione
    * @param end posizione finale per la suddivisione
    */
   public void sort(int threads, int[] array, int start, int end) {
        if (threads > 1) {
            int middle = halfSort(array, start, end);
            
            Thread sinistra = new Thread(() -> {
                sort(threads - 1, array, start, middle);
            });
            sinistra.start(); 
            Thread destra = new Thread(() -> {
                sort(threads - 1, array, middle, end);
            });
            destra.start(); 
                try {
                destra.join();
                sinistra.join();
            } catch (InterruptedException ex) {
            }
        } else {
            simpleSort(array,start, end);  
            
        }
    }
    /**
     * caso base della ricorsione del metodo sort()
     * ordinamento con bubble sort di porzioni ridotte dell'array
     * @param array array di cui ordinare i valori in una determinata sezione
     * @param start posizione dell'inizio della sezione
     * @param end posizione della fine della sezione
     */
    public void simpleSort(int[] array, int start, int end) {
        for (int i = start; i < end; i++) {
            boolean Sort = true;
            for (int j = 0; j < end -1; j++) {
                if (array[j] > array[j + 1]) {
                    
                    swap(array,j,j+1);
                    Sort = false;
                }
            }
            if (Sort) {
                break;
            }
        }
}
}
