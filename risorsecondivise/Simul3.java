package risorsecondivise;

/**
 *
 * @author Andrea Dattero
 */
public class Simul3 {
    public static void main(String[] args){
        Risorse[] r ={new Risorse("R1"),new Risorse("R2")};
        Task a = new Task(r,"stecco",3);
        Task b = new Task(r,"nella",2);
        new Thread(a).start();
        new Thread(b).start();
    }
}
