package pkg170929_state;

import java.util.Date;
import java.util.concurrent.TimeUnit;
/**
 *
 * @author federico.scaggiante
 */

public class Main{
    public static void main(String[] args) {
        DataDownloader ddl = new DataDownloader();
        Thread td = new Thread(ddl,"DataDownloaderThread");
        Thread tn = new NetworkConnection(td,"NetworkConnectionThread");
        tn.start();
        td.start();
    }
}