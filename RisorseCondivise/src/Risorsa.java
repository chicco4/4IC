import java.util.concurrent.Semaphore;

public class Risorsa {
    protected Semaphore tlight;
    private String name;

    public Risorsa (String name){
        this.name = name;
        this.tlight = new Semaphore(1, true);
    }

    public String getName(){
        return name;
    }

}
