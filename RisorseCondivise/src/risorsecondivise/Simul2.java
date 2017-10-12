package risorsecondivise;
public class Simul2{
    public static void main(String[] args){
        Risorsa risorsa1 = new Risorsa("resourse 1");
        Risorsa risorsa2 = new Risorsa("resourse 2");
        Thread thread1 =  new Thread(new Task(risorsa1, risorsa2), "Thread1");
        Thread thread2 =  new Thread(new Task(risorsa1, risorsa2), "Thread2");
        thread1.start();
        thread2.start();
    }
}