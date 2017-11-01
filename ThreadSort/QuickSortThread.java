package threadsort;

/**
 *
 * @author luca.daminato
 */
public class QuickSortThread extends Thread {

    private int[] arr;
    private int left;
    private int right;
    private int nThread;

    QuickSortThread(int arr[], int left, int right, int nThread) {
        this.arr = arr;
        this.left = left;
        this.right = right;
        this.nThread = nThread;
    }

    @Override
    public void run() {
        int index = partition(arr, left, right);
        if (nThread > 1) {
            Thread t1 = null;
            if (left < index - 1) {
                t1 = new QuickSortThread(arr, left, index-1, nThread-1);
                t1.start();
            }
            Thread t2 = null;
            if (index < right) {
                t2 = new QuickSortThread(arr, index, right, nThread-1);
                t2.start();
            }
            try {
                t1.join();
            } catch (InterruptedException ex) {}
            try {
                t2.join();
            } catch (InterruptedException ex) {}
        } else {
            if (left < index - 1) {
                quickSort(arr, left, index-1);
            }
            if (index < right) {
                quickSort(arr, index, right);
            }
        }
    }

    private void quickSort(int arr[], int left, int right) {
        int index = partition(arr, left, right);
        if (left < index-1) {
            quickSort(arr, left, index-1);
        }
        if (index < right) {
            quickSort(arr, index, right);
        }
    }

    private int partition(int arr[], int left, int right) {
        int i = left, j = right;
        int tmp;
        int pivot = arr[(left+right)/2];

        while (i <= j) {
            while (arr[i] < pivot) {
                i++;
            }
            while (arr[j] > pivot) {
                j--;
            }
            if (i <= j) {
                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }
        }
        return i;
    }

}
