package fileclock;
import java.util.Random;
public class TestFileClock{
    public static void main(String[] args){
        Thread clocks[] = new Thread[10];
        for(int i=0;i<10;i++){
            clocks[i] = new Thread(new FileClock());
            clocks[i].setName("Clock "+ i);
        }
        for(int i=0;i<10;i++){
            running(clocks, i);
        }
    }
    public static void running(Thread t[], int i){
        Random rn = new Random();
        int whichOne, howMuch;
        whichOne = rn.nextInt(10);
        howMuch = rn.nextInt(10000 - 1000 +1) + 1000;
        t[i].start();
        try{
            t[whichOne].sleep(howMuch);
            System.out.println("... " + t[i].getName() + " interrupted " + t[whichOne].getName() + " for " 
            + howMuch/1000 + " seconds\t"+t[whichOne].getName()+" --> TIMED_WAITING");
        }catch(InterruptedException ex){}
    }
}
