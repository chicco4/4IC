public class main{
    public static void main(String[] args) {
        int[] vector = Vectors.rnd(1000, 2000);
        System.out.print("MergeSort multi thread: ");
        long time = System.nanoTime();
        int[] out =  multiMerge(vector);
        System.out.println((System.nanoTime() - time) / 1000000.0 + "ms");
        for (int num : out)
            System.out.print(num + " ");
        System.out.println();
        time = System.nanoTime();
        System.out.print("MergeSort single thread: ");
        Vectors.mergeSort(vector);
        System.out.println((System.nanoTime() - time) / 1000000.0 + "ms");
        for (int num : vector)
            System.out.print(num + " ");
    }
    public static int[] multiMerge(int[] in){
        int[] copy = new int[in.length];
        int[] out = new int[in.length];
        for (int i = 0; i < in.length; i++) {
            copy[i] = in[i];
            out[i] = in[i];
        }
        Thread t1 = new Thread( () -> dividedMerge(out, 0, in.length/2, copy));
        t1.start();
        dividedMerge(out, in.length/2, in.length, copy);
        try {
            t1.join();
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
        merge(copy, 0, in.length/2, in.length, out);
        return out;
    }
    private static void dividedMerge(int[] vector2, int left, int right, int[] vector) {
        if (right - left < 2) {
            return;
        }
        int middle = (right + left) / 2;
        dividedMerge(vector, left, middle, vector2);
        dividedMerge(vector, middle, right, vector2);
        merge(vector2, left, middle, right, vector);
    }
    private static void merge(int[] vector, int left, int center, int right, int[] out) {
        int i = left;
        int j = center;
        for (int k = left; k < right; k++) {
            if (i < center && (j >= right || vector[i] <= vector[j])) {
                out[k] = vector[i];
                i++;
            } else {
                out[k] = vector[j];
                j = j + 1;
            }
        }
    }
}