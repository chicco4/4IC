package insertionSort;

public class threadSort implements Runnable {

    InsertionSort thread;
    int[] num;

    public threadSort(InsertionSort thread, int[] num) {
        this.num = num;
        this.thread = thread;
    }

    @Override
    public void run() {

        thread.insertionSort(num);
    }

}
