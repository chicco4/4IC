package task;

public class Task implements Runnable {

    private Risorsa risorsa;

    public Task(Risorsa risorsa) {
        this.risorsa = risorsa;
    }
    public Task(Risorsa... risorsa){
        this.risorsa=risorsa;
    }

    @Override
    public void run() {
        risorsa.aquisisciRisorsa();
        System.out.println("risorsa acquisita");
    }

}
