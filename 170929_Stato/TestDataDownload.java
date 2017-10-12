
public class TestDataDownload {
    public static void main(String[] args) {
        DataDownloader ddl = new DataDownloader();
        Thread td = new Thread(ddl,"DataDownloaderThread");
        System.out.println("ThreadDownload: " +td.getState());
        Thread tn = new NetworkConnection(td,"NetworkConnectionThread"); 
        System.out.println("ThreadNetwork: " +tn.getState());
        tn.start();
        System.out.println("ThreadNetwork: "+tn.getState());
        td.start();
        System.out.println("ThreadDownload: "+td.getState());
    }
}
