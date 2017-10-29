package ordinaarray;
import java.util.Random;
import java.util.Scanner;
import static ordinaarray.Sort.*;
/**
 * @author Romano Giacomo
 * Una semplice classe di prova che dato il numero di elementi dell' array da ordinare, e dato il numero di thread; genera
 * casualmente l' array e stampa il tempo, in millisecondi, impiegato da ogni metodo di ordinamento per ordinare l' array.
 */
public class OrdinaArrayTester{
    public static void main(String[] args) throws InterruptedException{
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        int[] arrayDaOrdinare, arrayOrdinato;
        final int numOfThreads, rangeVal;
        final String[] typeOfSorting = {"radixSort", "shellSort", "heapSort", "quickSort", 
                                        "mergeSort", "insertionSort", "selectionSort", "bubbleSort"};
        final double[] sortingTimes = new double[8];
        double startTime;
        System.out.print("Numero elementi dell' array:\t");
        arrayDaOrdinare = new int[input.nextInt()];
        arrayOrdinato = new int[arrayDaOrdinare.length];
        System.out.print("Numero di thread per l' ordinamento dell' array (0 < numero di thread < numero elementi array):\t");
        numOfThreads = input.nextInt();
        if(numOfThreads == 0 || numOfThreads > arrayDaOrdinare.length)
            return;
        System.out.print("Range di valori per l' array:\t 0 - ");
        rangeVal = input.nextInt();
	for(int i=0;i<arrayDaOrdinare.length;i++)
            arrayDaOrdinare[i] = random.nextInt(rangeVal);
        System.out.println("Tempo di ordinamento per i vari metodi:");
        for(int i=0;i<typeOfSorting.length;i++){
            System.out.print(typeOfSorting[i]+":\t");
            startTime = System.nanoTime();
            arrayOrdinato = sort(arrayDaOrdinare, numOfThreads, typeOfSorting[i]);
            sortingTimes[i] = System.nanoTime() - startTime;
            System.out.println(sortingTimes[i]/1000000+" ms");
        }
        for(int i=0;i<arrayOrdinato.length;i++){
            if(i%30 == 0)
                System.out.println();
            System.out.print("["+arrayOrdinato[i]+"]");
        }
        System.out.println();
    }
}