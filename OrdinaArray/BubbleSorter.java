import java.util.Random;

public class BubbleSorter {
    //Creazione array
    static int[] a=new int[1000];

    public static void main(String[] args) {
        Random rnd=new Random();
        long time;
        for(int i=0;i<a.length;i++) a[i]=rnd.nextInt(1000);

        //Ordinamento con un singolo Thread
        int[] copy=new int[a.length];
        for(int i=0;i<a.length;i++) copy[i]=a[i];
        Thread t1=new Thread( () -> {sort(copy);});
        time=System.nanoTime();
        t1.start();
        System.out.println("Un solo Thread: "+(System.nanoTime()-time) / 1000000.0 + "ms");

        //Ordinamento con due Thread
        int[] a1=new int[a.length/2];
        int[] a2=new int[a.length-a1.length];
        for(int i=0;i<a1.length;i++) a1[i]=a[1];
        for(int i=0;i<a2.length;i++) a2[i]=a[a1.length+1];
        Thread t2=new Thread( () -> {sort(a1);});
        Thread t3=new Thread( () -> {sort(a2);});
        time=System.nanoTime();
        t2.start();
        t3.start();
        System.out.println("Due Thread: "+(System.nanoTime()-time) / 1000000.0 + "ms");
    }


    //Metodi per l'ordinamento
    public static void sort(int array[]) {
        int k;
        for (int j = array.length; j >= 0; j--) {
            for (int i = 0; i < array.length - 1; i++) {
                k = i + 1;
                if (array[i] > array[k]) {
                    swapNumbers(i, k, array);
                }
            }
        }
    }

    private static void swapNumbers(int i, int j, int[] array) {
        int temp;
        temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
