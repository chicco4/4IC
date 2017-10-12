import java.util.Date;
import java.util.Arraylist;

class NetworkConnection extends Thread {
    
    ArrayList<Observer> observerList = new ArrayList<>();
    private boolean stateChange;
    private Thread td; // the downloader
    
    NetworkConnection(Thread td, String name){
        super(name);
        this.td = td;
    }
    
    @Override
    public void run() {
        System.out.printf("Network connected: %s\n",
                           new Date());
        try {
            td.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Network not connected: %s\n", 
                           new Date());
    }
	
}
