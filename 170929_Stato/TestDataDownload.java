import java.util.Date;
import java.util.concurrent.TimeUnit;

public class TestDataDownload {
    public static void main(String[] args) {
        DataDownloader ddl = new DataDownloader();
        Thread td = new Thread(ddl,"DataDownloaderThread");
        Thread tn = new NetworkConnection(td,"NetworkConnectionThread");
        Thread tt = new Terminated(td, tn);
        tn.start();tt.start();
        td.start();
        
    }
}

class DataDownloader implements Runnable {
    @Override
    public void run() {
        System.out.printf("Connecting: %s\n", new Date());
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Download finished: %s\n", new Date());
    }
}

class NetworkConnection extends Thread {
    
    private Thread td; // the downloadr
    
    NetworkConnection(Thread td, String name){
        super(name);
        this.td = td;
    }
    
    @Override
    public void run() {
        System.out.printf("Network connected: %s\n", new Date());
        try {
            td.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Network not connected: %s\n", new Date());
    }
}

public class Osservatore extends Thread{
	private final Thread t1;
	private final Thread t2;
    
    public Osservatore(Thread t1, Thread t2){
        this.t1 = t1;
        this.t2 = t2;
    }

    @Override
    public void run(){
        State s1 = t1.getState();
        State s2 = t2.getState();
        System.out.println("\t" + t1.getName() + " is " + s1);
        System.out.println("\t" + t2.getName() + " is " + s2);

        for(;;){
            if(!t1.getState().equals(s1)) {
                s1 = t1.getState();
                System.out.println("\t" + t1.getName() + " is " + s1);
            }
            if(!t2.getState().equals(s2)){
                s2 = t2.getState();
                System.out.println("\t" + t2.getName() + " is " + s2);
            }
            try{
                TimeUnit.MILLISECONDS.sleep(10);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
