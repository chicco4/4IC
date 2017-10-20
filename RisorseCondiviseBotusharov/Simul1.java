
package task;
public class Simul1 {
    public static void main(String[] args) {
        Risorsa x =new Risorsa(3,10);
        Thread threadX =new Thread(new Task(x));
        Risorsa y = new Risorsa(4,6);
        Thread threadY = new Thread(new Task(y));
        
        threadX.start();
        threadY.start();
        threadX.interrupt();
        threadY.interrupt();
    }
}
