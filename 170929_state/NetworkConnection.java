package pkg170929_stato;
/**
 *
 * @author GiovaUser
 */
import java.util.Date;

class NetworkConnection extends Thread {

    private Thread dwn;

    NetworkConnection(Thread dwn, String name){
        super(name);
        this.dwn = dwn;
    }

    @Override
    public void run() {
        System.out.println("Network connected: "+ new Date());
        try {
            dwn.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Network disconnected: "+ new Date());
    }
}