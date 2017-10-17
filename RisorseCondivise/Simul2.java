public class Simul2 {

    public static void main(String[] args) {
        
        Risorsa ris1 = new Risorsa("Risorsa 1");
        Risorsa ris2 = new Risorsa("Risorsa 2");
        Thread[] threads = new Thread[4];
        
        for(int i = 0; i<threads.length; i++){
            threads[i] = new Thread(new Task(ris1, ris2), "Thread"+(i+1));
        }
        for(int i = 0; i<threads.length; i++){
            threads[i].start();
        }
    }
    
}