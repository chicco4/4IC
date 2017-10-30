package ordinaarray;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author federico.scaggiante
 */
public class OrdinaArray {
	public static void main(String[] args) throws InterruptedException {
		/*Procedurale*/
                Random random=new Random();
                int a[] =new int[1000] ;
                for(int i=0;i<a.length;i++){
                    a[i]=random.nextInt();
                }
                QuickSort b=new QuickSort();
                long startTime = System.nanoTime();
                b.quickSort(a, 0, 9);
                long estimatedTime = System.nanoTime() - startTime;
                System.out.println("t:"+estimatedTime);
                int c[] =new int[1000] ;
                for(int i=0;i<c.length;i++){
                    c[i]=random.nextInt();
                }
                ThreadSort d=new ThreadSort(c,0,9,new Massimo());
                startTime = System.nanoTime();
                d.start();
                d.join();
                estimatedTime = System.nanoTime() - startTime;
                System.out.println("t(thread):"+estimatedTime);
	}
}