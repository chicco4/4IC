import java.util.concurrent.TimeUnit;
import java.util.Date;

public class TestDataDownload {

    public static void main(String[] args) {
        DataDownloader ddl = new DataDownloader();
        Thread td = new Thread(ddl,"DataDownloaderThread");
        Thread tn = new Network(td,"NetworkConnectionThread");
        Thread osserva = new Osservatore(td, tn);
        osserva.start();
        tn.start();
        td.start();
        try {
            TimeUnit.SECONDS.sleep(8);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        osserva.interrupt();
    }
}


class DataDownloader implements Runnable{

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


class Network extends Thread {
    private Thread td;

    Network(Thread td, String name){
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


class Osservatore extends Thread{
    private Thread td, tn;

    public Osservatore(Thread td, Thread tn){
        this.td = td;
        this.tn = tn;
    }

    @Override
    public void run(){
        Thread.State tdStato = td.getState();
        Thread.State tnStato = tn.getState();
        System.out.println(td.getName()+"; stato: "+tdStato);
        System.out.println(tn.getName()+"; stato: "+tnStato);
        while(true){
            if(!td.getState().equals(tdStato)) {
                tdStato = td.getState();
                System.out.println(td.getName()+"; stato: "+tdStato);
            }
            if(!tn.getState().equals(tnStato)){
                tnStato = tn.getState();
                System.out.println(tn.getName()+"; stato: "+tnStato);
            }
            try{
                TimeUnit.MILLISECONDS.sleep(10);
            } catch (InterruptedException e) {
                System.out.println("Osservazione degli stati completata");
                break;
            }
        }
    }
}