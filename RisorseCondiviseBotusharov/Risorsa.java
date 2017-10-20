/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task;

import java.util.concurrent.Semaphore;

/**
 *
 * @author sraem
 */
public class Risorsa {

    private final Semaphore semaphore;
    private final int end;
    private final int st;

    public Risorsa(int st,int end) {
        semaphore = new Semaphore(1);
        this.st=st;
        this.end=end;
    }

    public void aquisisciRisorsa() {
        try {
            int pos=0;
            semaphore.acquire();
            while (pos<st||pos>end)pos++;
        } catch (InterruptedException e) {
            semaphore.release();
        } finally {
            semaphore.release();
        }
    }

}
