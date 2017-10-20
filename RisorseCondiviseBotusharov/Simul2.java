
package task;

public class Simul2 {
    public static void main(String[] args) {
        Risorsa x =new Risorsa(3,10);
        Risorsa y = new Risorsa(4,6);
        Risorsa x2 =new Risorsa(6,12);
        Risorsa y2 = new Risorsa(5,8);
        Thread threadX =new Thread(new Task(x,x2));
        Thread threadY = new Thread(new Task(y,y2));
        
        threadX.start();
        threadY.start();
        threadX.interrupt();
        threadY.interrupt();
    }
}
