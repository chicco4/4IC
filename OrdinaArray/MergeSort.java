public class MergeSort{
	/**
	 Merge sort ricorsivo con un singolo thread
	 @param arg Array da ordinare
	 @return Nuovo array ordinato
	 */
	public static int[] mergeSortRecursive(int[] arg) {
		//duplicazione array
		int[] array = new int[arg.length];
		int[] workingArray = new int[arg.length];
		for (int i = 0; i < arg.length; i++) {
			array[i] = arg[i];
			workingArray[i] = arg[i];
		}
		//inizio ordinamento
		topDownSplitMerge(workingArray, 0, arg.length, array);
		return array;
	}
	/**
	 Merge sort ricorsivo con due thread (uno per metà)ù
	 @param arg Array da ordinare
	 @return Nuovo array ordinato
	 */
	public static int[] mergeSortRecursiveMultiThreading(int[] arg){
		//duplicazione array
        int[] array = new int[arg.length];
        int[] workingArray = new int[arg.length];
        for (int i = 0; i < arg.length; i++) {
            array[i] = arg[i];
            workingArray[i] = arg[i];
        }
        //avvio ordinamento prima metà con un nuovo thread
        Thread thread = new Thread(()->{
            topDownSplitMerge(workingArray, 0, arg.length/2, array);
        });
        thread.start();
        //ordino la seconda metà con il thread corrente
        topDownSplitMerge(workingArray, arg.length/2, arg.length, array);
        //aspetto che anche la prima metà sia ordinata
        try {
            thread.join();
        } catch (InterruptedException e) {
			System.err.println("Boh, nessuno dovrebbe poterlo interrompere");
        }
        //unisco (ed ordino) le due metà
        topDownMerge(array, 0, arg.length/2, arg.length, workingArray);
        return workingArray;
    }
    
    //metodi privati per il funzionamento del merge sort
	private static void topDownSplitMerge(int[] B, int begin, int end, int[] A) {
		//calcolo della metà
		if (end - begin < 2) {
			return;
		}
		int middle = (end + begin) / 2;
		//eseguo la ricorsione sulla prima metà
		topDownSplitMerge(A, begin, middle, B);
		//eseguo la ricorsione sulla seconda metà
		topDownSplitMerge(A, middle, end, B);
		//ordino le due metà
		topDownMerge(B, begin, middle, end, A);
	}
	private static void topDownMerge(int[] A, int begin, int middle, int end, int[] B) {
		int i = begin; //indice/cursore della prima metà
		int j = middle; //indice/cursore della seconda metà
		for (int k = begin; k < end; k++) { //scorro entrambe le metà (dall'inizo della prima alla fine della seconda)
			if (i < middle && (j >= end || A[i] <= A[j])) { //se non ho esaurito la prima metà controllo se ho esaurito la seconda o se l'emento i-esimo (prima metà) è più piccolo dell'elemento j-esimo (seconda metà)
				B[k] = A[i];
				i++;
			} else {
				B[k] = A[j];
				j++;
			}
		}
	}
	
	
}
