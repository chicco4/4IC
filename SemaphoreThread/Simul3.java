
package tasksemaforo;

/**
 *
 * @author David
 */
public class Simul3 {

    public static void main(String args[]) {
        
        Risorsa r1 = new Risorsa("Valore1");
        Risorsa r2 = new Risorsa("Valore2");
        
        Risorsa[] risorse1 = new Risorsa[]{r1,r2};
        Risorsa[] risorse2 = new Risorsa[]{r2,r1};
        
        Task task1 = new Task(risorse1,"Task1");
        Task task2 = new Task(risorse2,"Task2");
        
        Task[] array = new Task[]{task1,task2};
        
        Scheduler s = new Scheduler(array);
        
        Thread scheduler = new Thread(s);

        scheduler.start();
    }
}
