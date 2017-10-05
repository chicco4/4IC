package pkg170929_stato;
/**
 *
 * @author GiovaUser
 */
import static java.lang.Thread.sleep;

public class test {
    public static void main(String[] args) {
        DataDownloader one = new DataDownloader();
        Thread dwn = new Thread(one,"DataDownloaderThread");
        Thread nwk;
        nwk = new NetworkConnection(dwn,"NetworkConnectionThread");
        new Thread(new Observer(nwk)).start();
        try {
            sleep(1000);
        } catch (InterruptedException e) {
        e.printStackTrace();
        }
        nwk.start();
        dwn.start();
    }
}
