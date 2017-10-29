package ordinaarray;
import static ordinaarray.SortingAlgorithms.*;
/**
 * @author Romano Giacomo
 * La classe statica 'Sort', attraverso il metodo 'sort', ordina un array di interi con un certo numero di thread,
 * utilizzando ben otto metodi di ordinamento
 */
public final class Sort{
    private static Thread[] threads;
    private static int[] arrayDaOrdinare, arrayOrdinato;
    private static int index, count, memo;
    private static String typeOfSorting;
    public static int[] sort(int[] array){
        return sort(array, 1);
    }
    public static int[] sort(int[] array, int numOfThreads){
        return sort(array, numOfThreads, null);
    }
    public static int[] sort(int[] array, int numOfThreads, String sortingType){
        arrayDaOrdinare = array;
        arrayOrdinato = new int[0];
        threads = new Thread[numOfThreads];
        index = array.length/numOfThreads;
        count = 0;
        memo = 0;
        typeOfSorting = sortingType;
        for(int i=0;i<numOfThreads;i++)
            threads[i] = new Thread(new Task());
        try{
            for(int i=0;i<numOfThreads;i++){
                threads[i].start();
                threads[i].join();
            }
        }catch(InterruptedException ex){}
        return arrayOrdinato;
    }
    private static void composeArray(int[] sortedSubArray){
        //Aggiorno l' array ordinato fino ad ora
        int[] arrayTemp = new int[arrayOrdinato.length+sortedSubArray.length];
        int j = 0;
        System.arraycopy(arrayOrdinato, 0, arrayTemp, 0, arrayOrdinato.length);
        for(int i=arrayOrdinato.length;i<arrayTemp.length;i++,j++)
            arrayTemp[i] = sortedSubArray[j];
        arrayOrdinato = arrayTemp;
        //Per entrare nello switch, l' argomento non può essere 'null'
        if(typeOfSorting != null){
            switch(typeOfSorting){
                case "bubbleSort":
                    bubbleSort(arrayOrdinato);break;
                case "selectionSort":
                    selectionSort(arrayOrdinato);break;
                case "insertionSort":
                    insertionSort(arrayOrdinato);break;
                case "mergeSort":
                    mergeSort(arrayOrdinato);break;
                case "quickSort":
                    quickSort(arrayOrdinato);break;
                case "heapSort":
                    heapSort(arrayOrdinato);break;
                case "shellSort":
                    shellSort(arrayOrdinato);break;
                case "radixSort":
                    radixSort(arrayOrdinato);break;
                //Se la stringa che indica il tipo di ordinamento non corrisponde ad alcun metodo, viene segnalato che non
                //è stato trovato il metodo di ordinamento richiesto
                default:
                    System.out.println("**"+typeOfSorting+"** NON TROVATO");
            }
        //Nel caso in cui stringa che indica il tipo di ordinamento fosse 'null', e quindi non è stata specificata dall' utente,
        //di default viene fatto l' ordinamento dell' array con il 'quick sort'
        }else
            quickSort(arrayOrdinato);
    }
    //Classe Task che implementa l' interfaccia funzionale Runnable
    private static class Task implements Runnable{
        //Il metodo run, in base al numero di thread, assegna al thread corrente un pezzo dell' array da ordinare, per poi
        //chiamare il metodo 'composeArray'
        @Override
        public void run(){
            int[] subArray;
            int temp = 0;
            if((index*threads.length) != arrayDaOrdinare.length && memo == threads.length-1){
                subArray = new int[arrayDaOrdinare.length-(count*index)];
                for(int i=(count*index);i<arrayDaOrdinare.length;i++,temp++)
                    subArray[temp] = arrayDaOrdinare[i];
            }else{
                subArray = new int[index];
                for(int i=(count*index);i<(count*index)+index;i++,temp++)
                    subArray[temp] = arrayDaOrdinare[i];
                memo++;
            }
            count++;
            composeArray(subArray);
        }
    }
}