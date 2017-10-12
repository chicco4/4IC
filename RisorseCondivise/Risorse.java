package com.company;
import java.util.concurrent.Semaphore;

/**
 * Created by studente on 12/10/17.
 */
public class Risorse {
    protected Semaphore semaforo;
    private String nome;

    public Risorse(String n){
        this.nome=n;
        this.semaforo=new Semaphore(1);
    }

    public String getName() {
        return nome;
    }
}
