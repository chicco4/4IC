package pkg170929_stato;
/**
 *
 * @author GiovaUser
 */
public class Observer implements Runnable{
    private Thread obs;
    private String last;

    public Observer(Thread observed){
        this.obs = observed;
        this.last = "";
    }

    @Override
    public void run() {
        while(!last.equals("TERMINATED")){
            String state = obs.getState().name();
            if(!last.equals(state)){
                System.out.println("[OBSERVER]" + obs.getId() + " changed state from " + last + " to " + state);
                last = state;
            }
        }
    }
}