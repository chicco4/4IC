package threadsort;

/**
 *
 * @author federico.scaggiante
 */
public class MergeSortThread extends Thread {
    private int[] a;
    private int p, q, r;
    private int nThread;
    MergeSortThread(int[] a, int p, int r, int nThread) {
        this.a = a;
        this.p = p;
        this.r = r;
        this.nThread = nThread;
    }
    @Override
    public void run() {
        if (nThread > 1) {
            if (p == r) {
                return;
            }
            q = (p + r) / 2;
            Thread t1 = new MergeSortThread(a, p, q, nThread - 1);
            t1.start();
            Thread t2 = new MergeSortThread(a, q + 1, r, nThread - 1);
            t2.start();
            try {
                t1.join();
                t2.join();
            } catch (InterruptedException e) {
            }
        } else {
            if (p == r) {
                return;
            }
            int q = (p + r) / 2;
            mergeSort(a, p, q);
            mergeSort(a, q + 1, r);
        }
        ordina(a, p, q, r);
    }

    private void mergeSort(int[] a, int p, int r) {
        if (p == r) {
            return;

        }
        int q = (p + r) / 2;
        mergeSort(a, p, q);
        mergeSort(a, q + 1, r);
        ordina(a, p, q, r);
    }
    public void ordina(int[] a, int p, int q, int r) {
        int i = p;
        int k = p;
        int j = q + 1;
        int[] b = new int[r];
        while ((i <= q) && (j <= r)) {
            if (a[i] < a[j]) {
                b[k] = a[i];
                i++;
            } else {
                b[k] = a[j];
                j++;
            }
            k++;
        }
        int lun;
        if (i <= q) {
            lun = q - i + 1;
            System.arraycopy(a, i, a, k, lun);
        }
        lun = k - 1 - p + 1;
        System.arraycopy(b, p, a, p, lun);
    }
}
