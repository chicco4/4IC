package threadsort;
import java.util.Random;
import java.util.Arrays;

public class threadSort implements Runnable {
private static final int L = 20;
private static int[] nums;
private static Random rand;

public void run() {
    Arrays.sort(nums, nums.length/2, nums.length);
}

public static void main(String args[]) throws InterruptedException {

    nums = new int[L];
    rand = new Random();
    
    for(int i=0; i<nums.length; i++) {
        nums[i] = rand.nextInt(10);
    }

    Thread t = new Thread(new threadSort());
    t.start();

    Arrays.sort(nums, 0, nums.length/2);

    t.join();

    int j = 0;
    int k = nums.length/2; 
    int[] tmp = new int[nums.length];
    for (int i=0; i<tmp.length; i++){
        if (j < nums.length/2) {
            if (k < nums.length) {
                if (nums[j] < nums[k]) {
                    tmp[i] = nums[j++];
                } else {
                    tmp[i] = nums[k++];
                }
            } else {
                tmp[i] = nums[j++];
            }
        } else {
            tmp[i] = nums[k++];
        }
    }
    nums = tmp;

    int count = 0;

    for(int i=0; i<nums.length; i++){
    System.out.print(nums[i] + " ");
    count++;
    }
}
}