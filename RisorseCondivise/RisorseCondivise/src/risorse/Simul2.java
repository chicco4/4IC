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
public class Simul2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Risorsa[] r = new Risorsa[4];
		for(int i = 0; i < r.length; i++) {
			r[i] = new Risorsa("Risorsa "+i);
		}
        Thread thread1 = new Thread(new TaskConArrayRisorse(r));
        Thread thread2 = new Thread(new TaskConArrayRisorse(r));
        thread1.start();
        thread2.start();
    }
    
}
