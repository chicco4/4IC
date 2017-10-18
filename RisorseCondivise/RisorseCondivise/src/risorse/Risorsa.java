/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package risorse;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author FortuF100
 */
public class Risorsa {
    Semaphore permits;
    String name;
    public Risorsa(String name) {
        permits = new Semaphore(1);
        this.name = name;   
    }
    public void task() {
        try {
            permits.acquire();
            System.out.println(Thread.currentThread().getName()+" sta utilizzando la risorsa: "+name);
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } 
    }
	public void rilascia() {
		permits.release();
	}
}

