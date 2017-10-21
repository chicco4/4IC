public class FileClock extends Thread {
    private int clockId;

    public FileClock(int clockId){
        this.clockId = clockId;
    }

    public int getClockId(){
        return clockId;
    }

    private int random(int min, int max) {
        int range = (max - min) + 1;
        return (int)(Math.random() * range) + min;
    }

    @Override
    public void run() {
        while(TestFileClock.threads.size() > 1) {
            try {
                sleep(random(50, 10000));
            } catch (InterruptedException e) {
                System.out.println("[" + clockId + "] Aaaahh!");
                return;
            }
            FileClock killedThread = TestFileClock.threads.get(random(0, TestFileClock.threads.size()-1));
            if(killedThread.getClockId() != clockId && killedThread.isAlive()){
                System.out.println("[" + clockId + "] killed " + vittima.getClockId() );
                vittima.interrupt();
            }
        }
    }
}