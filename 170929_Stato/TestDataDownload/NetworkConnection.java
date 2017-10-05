import java.util.Date;

class NetworkConnection extends Thread {    
    private Thread thd;
    NetworkConnection(Thread td, String nome){
        super(nome);
        this.thd = td;
    }
    @Override
    public void run() {
        System.out.printf("Network connesso: %s\n",new Date());
        try {
            Thread oss1 = new Observer(Thread.currentThread(),"NetworkConnection");
            oss1.start();
            thd.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Network non connesso: %s\n",new Date());
    }
}