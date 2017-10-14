package radixSort;

public class threadSort implements Runnable {

    int[] num;

    public threadSort(int[] num) {
        this.num = num;
    }

    @Override
    public void run() {

        RadixSort.radixsort(num);
    }

}
