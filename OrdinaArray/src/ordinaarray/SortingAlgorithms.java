package ordinaarray;
/**
 * @author Romano Giacomo
 * Tutti gli algoritmi di ordinamento utilizzati nel progetto
 */
public class SortingAlgorithms{
    public static void bubbleSort(int[] array){
        boolean iVeChanged = true;
        for(int i=array.length;i>0 && iVeChanged;i--){
            iVeChanged = false;
            for(int j=1;j<i;j++){
                if(array[j-1] > array[j]){
                    swap(array, j-1, j);
                    iVeChanged = true;
                }
            }
        }
    }
    private static void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    public static void selectionSort(int[] array){
        for(int i=0;i<array.length-1;i++){
            int minPos = i;
            for(int j=i+1;j<=array.length-1;j++)
                if(array[j] < array[minPos])
                    minPos = j;
            int temp = array[minPos];
            array[minPos] = array[i];
            array[i] = temp;
        }
    }
    public static void insertionSort(int[] array){
        for(int j=1;j<=array.length-1;j++){  
            int bookMark = array[j];  
            int i = j-1;  
            for(;i>-1 && array[i]>bookMark;i--)
                array[i+1] = array[i];
            array[i+1] = bookMark;
        }
    }
    public static void mergeSort(int[] array){
        if(array.length <= 1)
            return;
        int[] first = new int[array.length/2];
        int[] second = new int[array.length-first.length];
		System.arraycopy(array, 0, first, 0, first.length);
        for(int i=0;i<second.length;i++)
            second[i] = array[first.length+i];
        mergeSort(first);
        mergeSort(second);
        merge(array,first,second);
    }
    private static void merge(int[] dest, int[] f, int[] s){
        int iFirst = 0, iSecond = 0, j = 0;
        while(iFirst < f.length && iSecond < s.length){
            if(f[iFirst] <= s[iSecond])
                dest[j++] = f[iFirst++];
            else
                dest[j++] = s[iSecond++];
        }
        while(iFirst < f.length)
            dest[j++] = f[iFirst++];
        while(iSecond < s.length)
            dest[j++] = s[iSecond++];
    }
    public static void quickSort(int[] array){
        quickSort(array, 0, array.length-1);
    }
    private static void quickSort(int[] array, int lowerIndex, int higherIndex){
        int i = lowerIndex;
        int j = higherIndex;
        int pivot = array[lowerIndex+(higherIndex-lowerIndex)/2];
        while(i <= j){
            while(array[i] < pivot)
                i++;
            while(array[j] > pivot)
                j--;
            if(i <= j){
                swap(array, i, j);
                i++;
                j--;
            }
        }
        if(lowerIndex < j)
            quickSort(array, lowerIndex, j);
        if(i < higherIndex)
            quickSort(array, i, higherIndex);
    }
    public static void heapSort(int[] array){
	buildheap(array);
	int sizeOfHeap=array.length-1;
	for(int i=sizeOfHeap;i>0;i--){
            swap(array,0, i);
            sizeOfHeap=sizeOfHeap-1;
            heapify(array, 0,sizeOfHeap);
        }
    }
    private static void buildheap(int []array){
        for(int i=(array.length-1)/2;i>=0;i--)
            heapify(array,i,array.length-1);
    }
    private static void heapify(int[] array, int i, int size){ 
        int left = 2*i+1;
        int right = 2*i+2;
        int max;
        if(left <= size && array[left] > array[i])
            max=left;
        else
            max=i;
        if(right <= size && array[right] > array[max])
            max=right;
        if(max!=i){
            swap(array,i, max);
            heapify(array, max,size);
        }
    }
    public static void shellSort(int[] array){
        int h;
        for(h=1;h<=array.length/3;h++)
            h = 3 * h + 1;
        while(h > 0){
            for(int i=0;i<array.length;i++){
                int temp = array[i];
                int j;
                for(j=i;j>h-1 && array[j-h]>=temp;j=j-h)
                    array[j] = array[j - h];
                array[j] = temp;
            }
            h = (h-1)/3;
        }
    }
    public static void radixSort(int array[]){
        int digitPlace = 1;
        int n=array.length;
        int result[]=new int[n];
        int largestNum = array[0];
        for(int i=1;i<array.length;i++)
            if(array[i] > largestNum)
                largestNum = array[i];
        while(largestNum/digitPlace >0){
            int count[]=new int[10];
            for(int i=0;i<10;i++)
                count[i] = 0;
            for(int i=0;i<n;i++)
                count[(array[i]/digitPlace)%10]++;
            for(int i=1;i<10;i++)
                count[i] += count[i - 1];
            for(int i=n-1;i>=0;i--){
                result[count[(array[i]/digitPlace)%10]-1] = array[i];
                count[(array[i]/digitPlace)%10]--;
            }
            for(int i=0;i<n;i++)
                array[i] = result[i];
            digitPlace *= 10;
        }
    }
}