package radixSort;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class ExampleRadixSort {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_PURPLE = "\u001B[35m";

    public static void main(String[] args) throws InterruptedException {

        Scanner input = new Scanner(System.in);
        System.out.println("Inserisci il numero di elementi da generare :");
        int numero = input.nextInt();
        System.out.println("_____________________________________________");

        /**
         * riempimento dell'array
         */
        int[] num = new int[numero];
        for (int a = 0; a < num.length; a++) {
            num[a] = (int) (Math.random() * 10000);
        }

        Thread t = new Thread(new threadSort(num));
        long startTime = System.nanoTime();
        t.start();
        long estimatedTime = System.nanoTime() - startTime;

        TimeUnit.MILLISECONDS.sleep(10);
        
        int count = 0;
        for (int h : num) {
            System.out.print(h + " ");
            count++;
        }

        /**
         * print the inters count
         */
        System.out.println("");
        System.out.println("____________________________________");
        System.out.println(ANSI_PURPLE + "Total amount of Integers = " + count + " item" + ANSI_RESET);
        System.out.println("____________________________________");
        System.out.println(ANSI_BLUE + "Time in millisecond : " + estimatedTime + " ms" + ANSI_RESET);
        System.out.println("____________________________________");
        System.out.println(ANSI_CYAN + "Time in second : " + estimatedTime / 1000 + " s" + ANSI_RESET);
        System.out.println("____________________________________");
    }

}
