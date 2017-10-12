package risorsecondivise;
public class Simul1{
    public static void main(String[] args){
        Risorsa risorsa = new Risorsa("resourse");
        Thread thread1 =  new Thread(new Task(risorsa), "Thread1");
        Thread thread2 =  new Thread(new Task(risorsa), "Thread2");
        thread1.start();
        thread2.start();
    }
}