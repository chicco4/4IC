package ordinamentoprova;

/**
 *
 * @author matteo
 */
public class OrdinamentoProva {

    public static void main(String[] args) throws InterruptedException {
        //Creazione Array
        int[] modello = new int[60];
        //Riempimento array
        riempiArray(modello, 300);
        int[] a = new int[70];
        riempiArray(a,300);
        int[] b = new int[70];
        riempiArray(b,300);
        int[] c = new int[70];
        riempiArray(c,300);
        int[] d = new int[70];
        riempiArray(d,300);
        //Inizializzazione array
        Thread threadBubble = new Thread();
        Thread threadMerge = new Thread();
        Thread threadSelection = new Thread();
        Thread threadQuick = new Thread();
        
        //Inizializzazione oggetti 
        BubbleSort bubbleSorter = new BubbleSort(a, threadBubble);
        MergeSort mergeSorter = new MergeSort(b, threadMerge);
        SelectionSort selectionSorter=new SelectionSort(c,threadSelection);
        QuickSort quickSorter =new QuickSort(2,d,threadQuick); //con doppio thread
        
        //Start dei vari thread
        bubbleSorter.start();
        mergeSorter.start();
        selectionSorter.start();
        quickSorter.start();//doppio thread
        
        
        
        Thread.sleep(1000);
        bubbleSorter.stampa();
        Thread.sleep(1000);
        mergeSorter.stampa();
        Thread.sleep(1000);
        selectionSorter.stampa();
        Thread.sleep(1000);
        quickSorter.stampa();
        
        

    }

    public static void riempiArray(int[] array, int Max) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (1 + Math.random() * Max);
        }
    }
}
