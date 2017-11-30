import java.util.concurrent.CountDownLatch;

/**
 *
 * @author luca.daminato
 */
public class MaggioreThreadMain {

	public static void main(String[] args) {
		int max = Integer.MIN_VALUE;
		
		int[] array = new int[100];
		int maxInt = 500, maxThread = 19, nThread = (int)(Math.random()*maxThread+2);
		for(int i=0; i<array.length; i++)
			array[i] = (int)(Math.random()*maxInt);
		
		CountDownLatch cdl = new CountDownLatch(nThread);
		int[] maggiori = new int[(int)cdl.getCount()];
		
		int nNumberThread = array.length/(nThread-1);
		
		long time = System.currentTimeMillis();
		
		Thread t;
		for(int i=0; i<nThread-1; i++){
			t = new Maggiore(cdl, array, nNumberThread*i, nNumberThread+nNumberThread*i, maggiori, i);
			t.start();
		}
		//Thread per la parte finale dell'array
		t = new Maggiore(cdl, array, nNumberThread*(nThread-1), array.length, maggiori, maggiori.length-1);
		t.start();
		
		try {
			cdl.await();
		} catch (InterruptedException ex) {}
		
		for(int i=0; i<maggiori.length; i++){
			if(maggiori[i] > max)
				max = maggiori[i];
		}
		
		System.out.println("Il massimo è "+max+", trovato su un array di "+array.length+" elementi con "+nThread+" Thread dopo "+(System.currentTimeMillis()-time)+" millisecondi.");
	}
}

class Maggiore extends Thread {
	private int[] a, maggiori;
	private int posIn, posFin, posMaggiori;
	private int max = Integer.MIN_VALUE;
	CountDownLatch cdl;
	
	public Maggiore(CountDownLatch cdl, int[] a, int posIn, int posFin, int[] maggiori, int posMaggiori){
		this.a = a;
		this.posIn = posIn;
		this.posFin = posFin;
		this.maggiori = maggiori;
		this.posMaggiori = posMaggiori;
		this.cdl = cdl;
	}
	
	@Override
	public void run() {
		for(int i=posIn; i<posFin; i++){
			if(a[i] > max)
				max = a[i];
		}
		maggiori[posMaggiori] = max;
		cdl.countDown();
	}
}