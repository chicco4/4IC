import java.util.Random;

public class mergeSort{

    public static int[] rnd(int length, int max){
        int[] out = new int[length];
        Random r = new Random();
        for(int i = 0; i < out.length; i++){
            out[i] = r.nextInt(max);
        }
        return out;
    }
    private static void mergeSort(int[] a, int[] vectorTemp, int left, int right) {
        if (left < right) {
            int center = (left + right) /2;
            mergeSort (a, vectorTemp, left, center);
            mergeSort (a, vectorTemp, center+1, right);
            merge (a, vectorTemp, left, center+1, right);
        }
    }

    public static void mergeSort(int[] a) {
        int vectorTemp [];
        vectorTemp = new int [a.length];
        mergeSort (a, vectorTemp, 0, a.length-1);
    }

    private static void merge(int[] a, int[] vectorAux, int posLeft, int posRight, int posEnd) {
        int endLeft = posRight -1;
        int posAux = posLeft;
        int numElemen = posEnd - posLeft +1;

        while (posLeft <= endLeft && posRight <=posEnd) {
            if ((a[ posLeft ])< (a[posRight]))
                vectorAux [posAux++]=a[posLeft++];
            else
                vectorAux [posAux++] = a[posRight++];
        }

        while (posLeft <= endLeft)
            vectorAux [posAux++]=a[posLeft++];

        while (posRight <= posEnd)
            vectorAux [posAux++]=a[posRight++];

        for (int i=0;i<numElemen;i++,posEnd--)
            a[posEnd]=vectorAux[posEnd];
    }

}