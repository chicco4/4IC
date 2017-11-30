package ricercamaggiore;

public class maggiore extends Thread{
	int max=Integer.MIN_VALUE;
	int[] array,maggiori;
	int inizio,fine;
	maggiore(int[] array, int inizio, int fine, int[] maggiori){
		this.array=array;
		this.fine=fine;
		this.inizio=inizio;
	}
	@Override
	public void run(){
		for(int i=0; i<array.length; i++){
			if(array[i]>max){
				max=array[i];
			}
		}
		for(int i=0; i<maggiori.length; i++){
			if(maggiori[i]==0){
				maggiori[i]=max;
			}
		}
	}
}
