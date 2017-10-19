import java.util.concurrent.Semaphore;

public class Risorsa {
    
    Semaphore semaphore;
    private String r;
    
    Risorsa(String r){
        semaphore = new Semaphore(1);
        this.r = r;
    }
    
    public void setRisorsa(String r){
        this.r = r;
    }
    
    public String getRisorsa(){
        return r;
    }
}
