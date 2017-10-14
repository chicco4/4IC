package bubbleSort;

public class threadSort implements Runnable {

    BubbleSort thread;
    int[] num;

    public threadSort(BubbleSort thread, int[] num) {
        this.thread = thread;
        this.num = num;
    }

    @Override
    public void run() {

        this.thread.bubbleSort(num);
    }

}
