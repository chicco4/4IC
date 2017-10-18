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
public class TaskConArrayRisorse implements Runnable {
    private Risorsa[] risorse; 
    public TaskConArrayRisorse(Risorsa[] r) {
        risorse = r;
    }
    @Override
    public void run() {
		if(risorse.length == 1) {
			System.out.println(Thread.currentThread().getName()+" sta per utilizzare la risorsa ");
			risorse[0].task();
			risorse[0].rilascia();
			System.out.println(Thread.currentThread().getName()+" ha finito di utilizzare la risorsa ");
		}
       for(int i = 0; i < risorse.length - 1; i ++) {
		   System.out.println(Thread.currentThread().getName()+" sta per utilizzare la risorsa "+i);
		   risorse[i].task();
		   System.out.println(Thread.currentThread().getName()+" sta per utilizzare la risorsa "+(i+1));
		   risorse[i+1].task();
		   risorse[i].rilascia();
		   System.out.println(Thread.currentThread().getName()+" ha finito di utilizzare la risorsa "+i);
		   risorse[i+1].rilascia();
		   System.out.println(Thread.currentThread().getName()+" ha finito di utilizzare la risorsa "+(i+1));
	   }
    }
}
