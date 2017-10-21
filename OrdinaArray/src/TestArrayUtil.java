import static java.lang.System.nanoTime;

public class TestArrayUtil {
    public static void main(String[] args) {
        int[] tmp;

        long start = nanoTime();
        int[] array = ArrayUtil.arrayRandom(10, 0, 10);
        System.out.print("Generazione array numeri casuali: ");
        System.out.println(((nanoTime() - start) / 1000) / 1000.0 + "ms");

        //BubbleSort il più lento
        /*start = nanoTime();
        ArrayUtil.bubbleSort(array);
        System.out.print("Ordinamento BubbleSort: ");
        System.out.println(((nanoTime()-start)/1000)/1000.0 + "ms");*/

        /*start = nanoTime();
        ArrayUtil.gnomeSort(array);
        System.out.print("Ordinamento GnomeSort: ");
        System.out.println(((nanoTime()-start)/1000)/1000.0 + "ms");*/

        /*start = nanoTime();
        ArrayUtil.selectionSort(array);
        System.out.print("Ordinamento SelectionSort: ");
        System.out.println(((nanoTime()-start)/1000)/1000.0 + "ms");*/

        start = nanoTime();
        tmp = ArrayUtil.mergeSortIterative(array);
        System.out.print("Ordinamento MergeSort iterativo: ");
        System.out.println(((nanoTime() - start) / 1000) / 1000.0 + "ms");
        System.out.print("[");
        for(int i=0; i<tmp.length; i++) System.out.print(tmp[i] + ",");
        System.out.println();

        start = nanoTime();
        tmp =  ArrayUtil.mergeSortRecursive(array);
        System.out.print("Ordinamento MergeSort ricorsivo: ");
        System.out.println(((nanoTime() - start) / 1000) / 1000.0 + "ms");
        System.out.print("[");
        for(int i=0; i<tmp.length; i++) System.out.print(tmp[i] + ",");
        System.out.println();

        start = nanoTime();
        tmp =  mergeSortRecursiveMultiThreading(array);
        System.out.print("Ordinamento MergeSort ricorsivo multithreading: ");
        System.out.println(((nanoTime() - start) / 1000) / 1000.0 + "ms");
        System.out.print("[");
        for(int i=0; i<tmp.length; i++) System.out.print(tmp[i] + ",");
        System.out.println();

        //RadixSort LSD, poco stabile, certe volte più veloce del MergeSort
        /*start = nanoTime();
        ArrayUtil.radixSortLSD(array);
        System.out.print("Ordinamento RadixSort LSD: ");
        System.out.println(((nanoTime() - start) / 1000) / 1000.0 + "ms");

        start = nanoTime();
        ArrayUtil.radixSortLSD1(array);
        System.out.print("Ordinamento RadixSort LSD prova1: ");
        System.out.println(((nanoTime() - start) / 1000) / 1000.0 + "ms");

        start = nanoTime();
        ArrayUtil.radixSortLSD2(array);
        System.out.print("Ordinamento RadixSort LSD prova2: ");
        System.out.println(((nanoTime() - start) / 1000) / 1000.0 + "ms");*/

        return;
    }
    public static int[] mergeSortRecursiveMultiThreading(int[] arg){
        int[] array = new int[arg.length];
        int[] workingArray = new int[arg.length];
        for (int i = 0; i < arg.length; i++) {
            array[i] = arg[i];
            workingArray[i] = arg[i];
        }
        Thread prova = new Thread(()->{
            topDownSplitMerge(workingArray, 0, arg.length/2, array);
        });
        prova.start();
        topDownSplitMerge(workingArray, arg.length/2, arg.length, array);
        try {
            prova.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        topDownMerge(array, 0, arg.length/2, arg.length, workingArray);
        return workingArray;
    }
    private static void topDownSplitMerge(int[] B, int begin, int end, int[] A) {
        if (end - begin < 2) {
            return;
        }
        int middle = (end + begin) / 2;
        topDownSplitMerge(A, begin, middle, B);
        topDownSplitMerge(A, middle, end, B);
        topDownMerge(B, begin, middle, end, A);
    }
    private static void topDownMerge(int[] A, int begin, int middle, int end, int[] B) {
        int i = begin;
        int j = middle;
        for (int k = begin; k < end; k++) {
            if (i < middle && (j >= end || A[i] <= A[j])) {
                B[k] = A[i];
                i++;
            } else {
                B[k] = A[j];
                j = j + 1;
            }
        }
    }
}
