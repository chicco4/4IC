package ordinathread;

public class Ordinamento {
    //metodo per ordinare l' array. Ho scelto bubble sort perchè è facile e veloce da scrivere
    private void bubSort(int[] a, int st, int end){

        for (int i = st; i < end; i++) {            
            boolean fine = false;
            for (int j = 0; j < end - 1; j++) {              
                if (a[j] > a[j + 1]) {
                    int k = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = k;
                    fine = true;
                } 
            }if(!fine) break;
        }        
    }
    
    public int split(int[] a, int st, int end) {
        int i = st;
        int j = end - 1;
        int temp;
        int mid = a[(st + end - 1)/2];

        while (i <= j) {

            while (a[i] < mid) 
                i++;
            while (a[j] > mid) 
                j--;

            if (i <= j) {
                temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i++;
                j--;
            }
        }
        return i;
    }

    private void sorting(int[] a, int st, int end, int threadsNum) {

        if (threadsNum > 1 && threadsNum != 0) {
            try {
                int mid = split(a, st, end);
                
                Thread sx = new Thread(() -> {sorting(a, st, mid, threadsNum - 1);});
                Thread dx = new Thread(() -> {sorting(a, mid, end, threadsNum - 1);});
                sx.start();
                dx.start();
                
                sx.join();
                dx.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else{
            try {
                Thread t = new Thread(() -> {bubSort(a, 0, a.length);});
                t.start();
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }    
    //ordinamento con più Thread dell' array
    public void threadSorting(int[] array, int threadsNum) throws InterruptedException {
        Thread t = new Thread(() -> {sorting(array, 0, array.length, threadsNum);});
        t.start();
        t.join();
    }    

}
