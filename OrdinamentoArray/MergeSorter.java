import java.util.Random;

public class MergeSorter implements Runnable{

    private int[] arr;
    private int Size;
    private int sinistra;
    private int destra;
    private int[] resultArray;

    public MergeSorter(int[] arr, int i, int j) {
        this.arr = arr;
        this.Size = arr.length;
        this.sinistra  = i;
        this.destra = j;
    }



    @Override
    public void run() {
        sort();
    }

    public static void main(String[] args) {
        Random random=new Random();
        int arr[] =new int[1000] ;
        for(int i=0;i<arr.length;i++){
            arr[i]=random.nextInt();
        }
        double startTime=System.currentTimeMillis();
        MergeSorter mr = new MergeSorter(arr,0,arr.length-1);
        Thread t = new Thread(mr);
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        double stopTime=System.currentTimeMillis();
        System.out.println("Tempo: "+(stopTime-startTime)+" ms");

    }

    private void sort() {
        if(sinistra== destra && sinistra >=0 )
        {
            this.resultArray = new int[]{arr[sinistra]};
            return;
        }
        if(sinistra> destra) return;
        int rightLimit = this.sinistra+(destra -sinistra)/2;
        MergeSorter mleft = new MergeSorter(arr,sinistra,rightLimit);
        Thread t1 = new Thread(mleft);
        t1.start();
        int leftlimit = 1 + rightLimit;
        MergeSorter mright= new MergeSorter(arr,leftlimit, destra);
        Thread t2 = new Thread(mright);
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        merge(mleft.resultArray,mright.resultArray);
    }

    private  int[] merge(int[] left, int[] right) {
        resultArray = new int[left.length+right.length];
        int r=0;
        int i=0;
        int j=0;
        while(i<left.length && j <right.length )
        {
            if( i<left.length && j<right.length && left[i] < right[j] )
                resultArray[r++] = left[i++];

            else if( j<right.length && i<left.length && right[j] < left[i])
                resultArray[r++] = right[j++];
        }
        while(i<left.length)
        {
            resultArray[r++] = left[i++];
        }
        while(j<right.length)
        {
            resultArray[r++] = right[j++];
        }
        return resultArray;
    }
}