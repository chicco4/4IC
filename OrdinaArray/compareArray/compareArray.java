package compareArray;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class compareArray {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_PURPLE = "\u001B[35m";

    public static void main(String[] args) throws InterruptedException {

        Scanner input = new Scanner(System.in);
        System.out.println("Inserisci il numero di elementi da generare :");
        int numero = input.nextInt();
        System.out.println("_____________________________________________");

        int[] num = new int[numero];
        for (int a = 0; a < num.length; a++) {
            num[a] = (int) (Math.random() * 10000);
        }

        //////////////////////////////////////////////////////////////////////////////
        BubbleSort primo = new BubbleSort();

        long startTime = System.nanoTime();
        primo.Sort(num);
        long estimatedTime = System.nanoTime() - startTime;

        TimeUnit.MILLISECONDS.sleep(10);

        System.out.println(ANSI_RED+"BubbleSort :");
        System.out.println("____________________________________");
        System.out.println("Total amount of Integers = " + num.length + " item");
        System.out.println("____________________________________");
        System.out.println(ANSI_BLUE + "Time in millisecond : " + estimatedTime + " ms" + ANSI_RESET);
        System.out.println("____________________________________");
        System.out.println(ANSI_CYAN + "Time in second : " + estimatedTime / 1000 + " s" + ANSI_RESET);
        System.out.println("____________________________________");

        InsertionSort secondo = new InsertionSort();

        startTime = System.nanoTime();
        secondo.Sort(num);
        estimatedTime = System.nanoTime() - startTime;

        TimeUnit.MILLISECONDS.sleep(10);

        System.out.println(ANSI_RED+"InsertionSort :");
        System.out.println("____________________________________");
        System.out.println("Total amount of Integers = " + num.length + " item");
        System.out.println("____________________________________");
        System.out.println(ANSI_BLUE + "Time in millisecond : " + estimatedTime + " ms" + ANSI_RESET);
        System.out.println("____________________________________");
        System.out.println(ANSI_CYAN + "Time in second : " + estimatedTime / 1000 + " s" + ANSI_RESET);
        System.out.println("____________________________________");

        MergeSort terzo = new MergeSort();

        startTime = System.nanoTime();
        terzo.Sort(num);
        estimatedTime = System.nanoTime() - startTime;

        TimeUnit.MILLISECONDS.sleep(10);

        System.out.println(ANSI_RED+"MergeSort :");
        System.out.println("____________________________________");
        System.out.println("Total amount of Integers = " + num.length + " item");
        System.out.println("____________________________________");
        System.out.println(ANSI_BLUE + "Time in millisecond : " + estimatedTime + " ms" + ANSI_RESET);
        System.out.println("____________________________________");
        System.out.println(ANSI_CYAN + "Time in second : " + estimatedTime / 1000 + " s" + ANSI_RESET);
        System.out.println("____________________________________");

        QuickSort quarto = new QuickSort();

        startTime = System.nanoTime();
        quarto.Sort(num);
        estimatedTime = System.nanoTime() - startTime;

        TimeUnit.MILLISECONDS.sleep(10);

        System.out.println(ANSI_RED+"QuickSort :");
        System.out.println("____________________________________");
        System.out.println("Total amount of Integers = " + num.length + " item");
        System.out.println("____________________________________");
        System.out.println(ANSI_BLUE + "Time in millisecond : " + estimatedTime + " ms" + ANSI_RESET);
        System.out.println("____________________________________");
        System.out.println(ANSI_CYAN + "Time in second : " + estimatedTime / 1000 + " s" + ANSI_RESET);
        System.out.println("____________________________________");

        RadixSort quinto = new RadixSort();

        startTime = System.nanoTime();
        quinto.Sort(num);
        estimatedTime = System.nanoTime() - startTime;

        TimeUnit.MILLISECONDS.sleep(10);

        System.out.println(ANSI_RED+"RadixSort :");
        System.out.println("____________________________________");
        System.out.println("Total amount of Integers = " + num.length + " item");
        System.out.println("____________________________________");
        System.out.println(ANSI_BLUE + "Time in millisecond : " + estimatedTime + " ms" + ANSI_RESET);
        System.out.println("____________________________________");
        System.out.println(ANSI_CYAN + "Time in second : " + estimatedTime / 1000 + " s" + ANSI_RESET);
        System.out.println("____________________________________");

        SelectorSort sesto = new SelectorSort();

        startTime = System.nanoTime();
        sesto.Sort(num);
        estimatedTime = System.nanoTime() - startTime;

        TimeUnit.MILLISECONDS.sleep(10);

        System.out.println(ANSI_RED+"SelectorSort :");
        System.out.println("____________________________________");
        System.out.println("Total amount of Integers = " + num.length + " item");
        System.out.println("____________________________________");
        System.out.println(ANSI_BLUE + "Time in millisecond : " + estimatedTime + " ms" + ANSI_RESET);
        System.out.println("____________________________________");
        System.out.println(ANSI_CYAN + "Time in second : " + estimatedTime / 1000 + " s" + ANSI_RESET);
        System.out.println("____________________________________");
    }
}
