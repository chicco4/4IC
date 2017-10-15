/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simul3;

import java.util.concurrent.Semaphore;

/**
 *
 * @author matteo
 */
public class Risorsa {
    // Una sola risorsa per il caso simul1
    static Semaphore semaphore = new Semaphore(4);
}
