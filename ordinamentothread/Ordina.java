package ordinamentothread;

import static java.util.Arrays.sort;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author david.ambros
 */
class Ordina  {
	private int[] array;
	private int numeroThread;

	public Ordina(int[] array, int numeroThread) {
		ordinamento(numeroThread,array,0,array.length);
	}



	private void ordinamento(int numeroThread, int[] array, int inzio, int fine) {
		if(numeroThread>1){
			int mezzo = separa(array,inzio,fine);
			// caso generico
			Thread sinistra =new Thread(()->{
				ordinamento( numeroThread-1,array,inzio,mezzo);
			});
			Thread destra =new Thread(()->{
				ordinamento( numeroThread-1,array,mezzo,fine);
			});
			sinistra.start();destra.start();
			
			try {
				sinistra.join();destra.join();
			} catch (InterruptedException ex) {
			}
			
		}else{
			//caso specifico
			sort(array,inzio,fine);
		}
	}

	
	int separa(int arr[], int left, int right){
      int i = left, j = right-1;
      int tmp;
      int pivot = arr[(left + right -1) / 2];
     
      while (i <= j) {
            while (arr[i] < pivot)
                  i++;
            while (arr[j] > pivot)
                  j--;
            if (i <= j) {
                  tmp = arr[i];
                  arr[i] = arr[j];
                  arr[j] = tmp;
                  i++;
                  j--;
            }
      }
      return i;
}
}
