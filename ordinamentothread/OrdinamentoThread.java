package ordinamentothread;

import java.util.Arrays;
import static java.util.Arrays.sort;

/**
 *
 * @author david.ambros
 */
public class OrdinamentoThread {

	public static void main(String[] args) {
		int a[]=new int[10000000];
		int b[]=new int[a.length];
		for (int i = 0; i < a.length; i++) {
			a[i]=(int) (Math.random()*10000);
			b[i]=a[i];
		}
		int numeroThread=10;
		//System.out.println(Arrays.toString(a));
		long tempo=System.currentTimeMillis();
		Ordina o=new Ordina(a, numeroThread);
		System.out.println("con" +numeroThread + "thread impiega " +(System.currentTimeMillis()-tempo)+ " secondi");
		//System.out.println(Arrays.toString(a));
		 long tempo1=System.currentTimeMillis();
		sort(b);
		System.out.println("con 0 thread impiega " +(System.currentTimeMillis()-tempo1)+ " secondi");
		//System.out.println(Arrays.toString(b));
	}
	
}
