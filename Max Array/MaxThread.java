import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.CountDownLatch;

// waiting multiple concurrent events

public class MaxThread {
	static int [] array=new int[100];
	static int numberThread=2;
    static int counter=0;
    public static void main(String[] args) {
		riempimentoInt(); //Riempie l'array con numeri random
		ThreadMax t = new ThreadMax(numberThread); //Dici il numero di Thread 
		Thread tm = new Thread(t);
		tm.start();
		for (int i=0; i<numberThread; i++){
            Treads p = new Treads(t, "Tread " + i, suddivisioneArray(numberThread), numberThread);
            Thread t1 = new Thread(p);
            t1.start();
        }
    }
    public static void riempimentoInt(){
		for (int i = 0; i < array.length; i++){
			array[i]=(int)(Math.random());
		}
		
	}
	public static int[] suddivisioneArray(int x){
		int [] a=new int [(int)(array.length/x)];
		for (int i = 0; i < a.length; i++, counter++){
			a[i]=array[counter];
		}
		return a;
	}
}

class ThreadMax implements Runnable{
	static int c=0;
	static int [] maxNumber;
	static int numberThread=0;
    private final CountDownLatch controller;
    public ThreadMax(int number) {
        controller = new CountDownLatch(number);
        this.numberThread=numberThread;
        this.maxNumber=new int [numberThread];
    }
    public void finished(String name, int max){
        System.out.printf("%s has finished.\n", name);
        maxNumber[c]=max;
        this.c++;
        controller.countDown();
        System.out.printf("Waiting for %d Thread.\n",
        controller.getCount());
    }
    @Override
    public void run() {
		int max=0;
        System.out.printf("Searching max: Initialization: %d participants.\n",
        controller.getCount());
        try {
            controller.await(); 
            System.out.printf("All the Thread have finished\n");
            System.out.printf("Let's start search the max number...\n");
            for (int i = 0; i < numberThread; i++){
				if(maxNumber[i]<max){
					max=maxNumber[i];
				}
			}
			System.err.println("Il numero più grande è: "+max);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void x(int t){
		this.maxNumber=new int [t];
	}
}

class Treads implements Runnable {
	static final Random random = new Random((new Date()).getTime());
	static int Thread=0;
    static int [] array;
    static int counter=0;
    static int max=0;
    private ThreadMax conference;
    private String name;
    
    public Treads(ThreadMax conference, String name, int [] array, int t) {
        this.conference = conference;
        this.name = name;
        this.array=array;
        this.Thread=t;
    }
    @Override
    public void run() {
        try {
			for (int i = 0; i < array.length; i++){
				if (array[i]>max)
					max=array[i];
			}
			getMax();
			TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        conference.x(Thread);
        conference.finished(name, getMax());
    }
    public int getMax(){
		return this.max;
	}
}
