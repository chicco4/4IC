package quickSort;

public class threadSort implements Runnable {

    QuickSort thread;
    int[] num;

    public threadSort(QuickSort thread, int[] num) {
        this.num = num;
        this.thread = thread;
    }

    @Override
    public void run() {

        thread.quicksort(num);
    }

}
