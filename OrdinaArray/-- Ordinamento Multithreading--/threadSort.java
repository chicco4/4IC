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
        int i = 0;
        int[] num1 = null;
        int[] num2 = null;
        while (i < num.length / 2) {
            num1[i] = num[i];
            i++;
        }
        i = num.length;
        while (i < num.length) {
            num2[i] = num[i];
            i++;
        }
        thread.quicksort(num1);
        thread.quicksort(num2);
        int j = 0;
        while (j < num1.length) {
            num[j] = num1[j];
            j++;
        }
        int k = j;
        while (k < num2.length * 2) {
            num[k] = num2[k];
            k++;
        }
        thread.quicksort(num);
    }

}
