
package task;

public class Simul3 {
    public static void main(String[] args) {
        Risorsa x =new Risorsa(6,10);
        Risorsa y = new Risorsa(5,8);
        Risorsa x2 =new Risorsa(7,12);
        Risorsa y2 = new Risorsa(4,6);
        Thread threadX =new Thread(new Task(x,x2));
        Thread threadY = new Thread(new Task(y,y2));
        
        threadX.start();
        threadY.start();
        threadX.interrupt();
        threadY.interrupt();
    }
}
