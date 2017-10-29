package risorsa;
public class Scheduler implements Runnable{
    
    Task[] arrayTask;
    public Scheduler(Task[] arrayTask) {
        this.arrayTask = arrayTask;
    }

    @Override
    public void run() {
        for (Task array : arrayTask) {
             new Thread(array::acquisizione).start();
        }
    }
}