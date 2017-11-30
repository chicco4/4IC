import java.util.concurrent.CountDownLatch;
import java.util.Scanner;

public class Test{

public static void main(String[] args) { 
Scanner input = new Scanner(System.in);
System.out.println("Inserisci un numero :");
int numero = input.nextInt();
System.out.println("_____________________________________________");
Search istanza = new Search();
int[] array = istanza.fillArray(new int[numero]);
int totalThreads = 10;
int[] results = new int[totalThreads];
int chunkSize = array.length / totalThreads;
CountDownLatch end = new CountDownLatch(totalThreads);
for (int i = 0; i < totalThreads; i++) {
    int threadIndex = i;
    new Thread(
        () -> {
            int max = -1;
            int startIndex = threadIndex * chunkSize;
			for (int k = 0; k < array.length; k++) {
				if (max <  array[k]) {
					max = array[k];
				}
			}
            results[threadIndex] = max;
            end.countDown();
        }
    ).start();
}

int max = results[0];
for (int k = 1; k < results.length; k++) {
    if (max < results[k]) {
        max = results[k];
    }
}
System.out.println();
System.out.println("_____________________________________________");
System.out.printf("Max found %d%n", max);
System.out.println("_____________________________________________");
}
}
