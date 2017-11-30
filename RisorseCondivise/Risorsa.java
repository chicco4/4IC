/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simul1;

import java.util.concurrent.Semaphore;
import java.lang.InterruptedException;
	
public class Risorsa{
	String nome;
	Semaphore semaforo;
	
	public Risorsa(String nome){
		this.nome=nome;
		semaforo=new Semaphore(1);
	}
	
	public void acquire(){
		try{semaforo.acquire();}
		catch(InterruptedException e){e.printStackTrace();}
	}
	
	public void release(){
		semaforo.release();
	}
}