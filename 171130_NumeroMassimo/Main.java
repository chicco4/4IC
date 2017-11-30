import java.util.Random;

public class Main{
public static void main(String[] args){

	final int Max=100;
	int[] array=new int[Max];
	
	Random nRandom=new Random();
	
	for(int i=0;i<Max;i++){
		array[i]=nRandom.nextInt(1000);
		System.out.println(array[i]);
	}
	
	Thread t=new Results(array, 10);
	t.start();
}
}
