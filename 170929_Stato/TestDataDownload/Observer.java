import java.util.concurrent.TimeUnit;


class Observer extends Thread{
    private Thread thd;  
    Observer(Thread td, String nome){
        super(nome);
        thd = td;
    }
    @Override
    public void run() {
        for(int i=0; i<10; i++){
            try {
                Ricarica();
                TimeUnit.MILLISECONDS.sleep(500);
            }catch(InterruptedException e) {
                System.out.println("Non funziona");
            }
        }
    }	
    public void Ricarica(){
	System.out.println("Lo stato di "+thd.getName()+" è "+thd.getState());
    }
}