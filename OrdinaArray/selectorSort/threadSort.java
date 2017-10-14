package selectorSort;

public class threadSort implements Runnable {

    SelectorSort thread;
    int[] num;

    public threadSort(SelectorSort thread, int[] num) {
        this.num = num;
        this.thread = thread;
    }

    @Override
    public void run() {

        thread.selectionSort(num);
    }

}
