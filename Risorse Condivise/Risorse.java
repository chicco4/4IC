/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package risorsecondivise;
import java.util.concurrent.Semaphore;
/**
 *
 * @author feder
 */
public class Risorse {
    protected Semaphore semaforo;
    private String name;

    public Risorse (String name){
        this.name = name;
        this.semaforo = new Semaphore(1, true);
    }

    public String getName(){
        return name;
    }
}
