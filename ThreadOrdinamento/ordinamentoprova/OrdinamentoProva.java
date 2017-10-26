package ordinamentoprova;

/**
 *
 * @author matteo
 */
public class OrdinamentoProva {

    public static void main(String[] args) {
        //Creazione Array
        int[] modello = new int[600000];
        //Riempimento array
        riempiArray(modello, 300);
        int[] a = modello;
        int[] b = modello;
        int[] c = modello;
        int[] d = modello;
        //Inizializzazione array
        Thread threadBubble = new Thread();
        Thread threadMerge = new Thread();
        Thread threadSelection = new Thread();
        Thread threadQuick = new Thread();
        //Inizializzazione oggetti
        MergeSort mergeSorter = new MergeSort(a, threadMerge);
        BubbleSort bubbleSorter = new BubbleSort(b, threadBubble);
        QuickSort quickSorter =new QuickSort(c,threadSelection);
        SelectionSort selectionSorter=new SelectionSort(d,threadQuick);
        //Inizio dei vari thread
        bubbleSorter.start();
        mergeSorter.start();
        quickSorter.start();
        selectionSorter.start();
        
        
        

    }

    public static void riempiArray(int[] array, int Max) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (1 + Math.random() * Max);
        }
    }
}
