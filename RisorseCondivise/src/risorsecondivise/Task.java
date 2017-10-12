package risorsecondivise;
public class Task implements Runnable{
    private Risorsa risorsa1;
    private Risorsa risorsa2;
    public Task(Risorsa risorsa){
        this.risorsa1 = risorsa;
    }
    public Task(Risorsa risorsa1, Risorsa risorsa2){
        this.risorsa1 = risorsa1;
        this.risorsa2 = risorsa2;
    }
    @Override
    public void run(){
        if(risorsa2 == null){	//Abbiamo solo una risorsa
            System.out.printf("%s: Going to acquire the resourse\n", Thread.currentThread().getName());
            risorsa1.acquireResourse();
            risorsa1.releaseResourse();
            System.out.printf("%s: The resourse has been released\n", Thread.currentThread().getName());
        }else{	//Abbiamo 2 risorse
            System.out.printf("%s: Going to acquire the "+risorsa1.name+"\n", Thread.currentThread().getName());
            risorsa1.acquireResourse();
            System.out.printf("%s: Going to acquire the "+risorsa2.name+"\n", Thread.currentThread().getName());
            risorsa2.acquireResourse();	//In questo momento il thread sta usando entrambe le risorse
            risorsa1.releaseResourse();
            System.out.printf("%s: The "+risorsa1.name+" has been released\n", Thread.currentThread().getName());
            risorsa2.releaseResourse();
            System.out.printf("%s: The "+risorsa2.name+" has been released\n", Thread.currentThread().getName());
        }
    }
}