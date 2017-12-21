package threadsort;

/**
 *
 * @author federico.scaggiante
 */
public class MergeSort {
    public static void mergeSort(int[] a, int p, int r) {
        if (p == r) {
            return;
        }
        int q = (p + r) / 2;
        mergeSort(a, p, q);
        mergeSort(a, q + 1, r);
        merge(a, p, q, r);
    }
    private static void merge(int[] a, int p, int q, int r) {
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
