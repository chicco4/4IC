/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package risorse;

/**
 *
 * @author FortuF100
 */
public class Task implements Runnable {
    private Risorsa risorsa1, risorsa2;
    public Task(Risorsa r) {
        risorsa1 = r;
    }
    public Task(Risorsa r1, Risorsa r2) {
        risorsa1 = r1;
        risorsa2 = r2;
    }
    @Override
    public void run() {
       
        if(risorsa2 != null) {
			System.out.println(Thread.currentThread().getName() + " sta per utilizzare la risorsa: " + risorsa1.name);
			risorsa1.task();
			System.out.println(Thread.currentThread().getName()+" sta per utilizzare la risorsa: "+risorsa2.name);
			risorsa2.task();
			risorsa1.rilascia();
			System.out.println(Thread.currentThread().getName() + " ha finito di utilizzare la risorsa: " + risorsa1.name);
			risorsa2.rilascia();
            System.out.println(Thread.currentThread().getName()+" ha finito di utilizzare la risorsa: "+risorsa2.name);
        } else {
			System.out.println(Thread.currentThread().getName() + " sta per utilizzare la risorsa: " + risorsa1.name);
			risorsa1.task();
			risorsa1.rilascia();
			System.out.println(Thread.currentThread().getName() + " ha finito di utilizzare la risorsa: " + risorsa1.name);
		}
    }
}
