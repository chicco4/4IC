/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package risorsecondivise;

/**
 *
 * @author Marco
 */
public class Simul3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Risorsa r1=new Risorsa("r1");
        Risorsa r2=new Risorsa("r2");
        Thread t1=new Thread(new Task(r1, r2));
        Thread t2=new Thread(new Task(r2, r1));
        t1.start();
        t2.start();
    }
}