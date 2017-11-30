/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maxesercizio;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author matteo.pagano
 */
public class Max implements Runnable {

    private int[] array;
    private int max = 0;
    static int val = 0;

    public Max(int[] array) {
        this.array = array;
    }

    @Override
    public void run() {
        int max = 0;
        for (int i = 0; i < this.array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        this.max = max;
    }

    public int getMax() {
        return max;
    }

    public static void main(String[] args) {
        int[] arr = new int[20];
        riempimento(arr, 200000000);
        int numeroArray = 5;
        Max[] lista = new Max[numeroArray];
        for (int i = 0; i < lista.length; i++) {
            lista[i] = new Max(dividi(arr, numeroArray));
            lista[i].run();
        }
        
        stampaIMax(lista);
    }

    static int numRandom(int min, int max) {
        return (int) (Math.random() * (max - min) + min);
    }

    static void riempimento(int[] a, int max) {
        for (int i = 0; i < a.length; i++) {
            a[i] = numRandom(1, max);
        }
    }

    static int[] dividi(int[] array, int nArray) {
        int[] array1;
        array1 = new int[array.length / nArray];
        int divisioneArray = array.length / nArray;

        for (int i = val, j = 0; j < divisioneArray; i++, j++) {
            array1[j] = array[i];
        }
        val += array.length / nArray;
        return array1;
    }

    static public void stampa(int array[]) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(i + " " + array[i]);
        }
    }

    static public void stampaIMax(Max[] i) {
        for (int j = 0; j < i.length; j++) {
            System.out.print(i[j].getMax() + "  ");
        }

    }

    public static int searchMax(int[] array) {
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }
}
