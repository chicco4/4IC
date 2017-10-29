package risorsa;
public class Simul1 {

    public static void main(String args[]) {
        Risorsa r = new Risorsa("Esempio");
        
        Task task1 = new Task(r,"Task1");
        Task task2 = new Task(r,"Task2");
        Task[] array = new Task[]{task1,task2};
        
        Scheduler s = new Scheduler(array);
        
        Thread scheduler = new Thread(s);

        scheduler.start();
    }
}