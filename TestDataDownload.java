import java.util.Date;
import java.util.concurrent.TimeUnit;

public class TestDataDownload {
    public static void main(String[] args) throws InterruptedException{
        DataDownloader ddl = new DataDownloader();
        Thread td = new Thread(ddl,"DataDownloaderThread");
        Thread tn = new NetworkConnection(td,"NetworkConnectionThread");
	    Thread osservatore = new Osservatore();
	    tn.start();
        td.start();
    }
}


class DataDownloader implements Runnable {
    
    @Override
    public void run() {
        System.out.printf("Connecting: %s\n",
                           new Date());
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Download finished: %s\n", 
                           new Date());
    }
}

class NetworkConnection extends Thread {
    
    private Thread td; 
    
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

class osservatore implements Runnable{
	private Thread osservato;
	osservatore(Thread osservato){
		this.osservato=osservato;
	}
	public void aggiornaStato(){
		 System.out.println(osservato.getName() + " is " + osservato.getState().name());
    }
   @Override
    public void run() {
        
        aggiornaStato();
        
        while (osservato.name().getState()!="TERMINATED") {
            String statoPrecedente = osservato.getState().name();

            while (statoPrecedente==osservato.getState().name()) {
            }
	    aggiornaStato(); 
        }
        
    }
}