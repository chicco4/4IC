package pkg170929_state;

import java.util.Date;

/**
 *
 * @author federico.scaggiante
 */
class NetworkConnection extends Thread {    
    private Thread td;
    NetworkConnection(Thread td, String name){
        super(name);
        this.td = td;
    }
    @Override
    public void run() {
        System.out.printf("Network connected: %s\n",new Date());
        try {
            Thread osservatore = new Observer(Thread.currentThread(),"NetworkConnection");
            osservatore.start();
            td.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Network not connected: %s\n",new Date());
    }
}
