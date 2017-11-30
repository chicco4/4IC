import java.util.Scanner;

public class Search {

    public int[] fillMatrix(int matrix[]) {
        for (int i = 0; i < matrix.length; i++){
              matrix[i] = (int)(Math.random() * 1000);
              System.out.print(matrix[i]+" ");
            
        }
        return matrix;
    }

    public int searchMaxValue(int[] matrix) {
        int max = matrix[0];
        for (int a = 0; a < matrix.length; a++) {

                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (matrix[a] > max) {
                    max = matrix[a];
                }
            
        }
        return max;
    }

	
	
    public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.println("Inserisci un numero :");
		int numero = input.nextInt();
		System.out.println("_____________________________________________");
		
        Search search = new Search();
        int[] matrix = new int[numero];
        search.fillMatrix(matrix);
     
        int max = search.searchMaxValue(matrix);
       
        System.out.println();
        System.out.println("_____________________________________________");
        System.out.println("Max value is " + max);
        System.out.println("_____________________________________________");
        
    }
}
