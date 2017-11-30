package maxarray;

import java.util.Random;

public class Main{
	public static void main(String[] args){
	
		final int MAX=1000;
		int[] array=new int[MAX];
	
		Random rnd=new Random();
		
		for(int i=0;i<array.length;i++){
			array[i]=rnd.nextInt(1000);
			System.out.println(array[i]);
		}
		
		Thread t=new GetMax(array,20);
		t.start();
	
	}
}
