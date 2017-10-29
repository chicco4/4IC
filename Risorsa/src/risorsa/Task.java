package risorsa;

import java.util.Date;
import java.util.Random;

public class Task {

    private Random random;
    private Risorsa[] risorse;
    private String nome;
    private String cast;

    public Task(Risorsa[] arrayRisorse, String nome) {
        this.nome = nome;
        this.risorse = arrayRisorse;
        random = new Random((new Date()).getTime());
    }

    public Task(Risorsa r, String nome) {
        this.nome = nome;
        risorse = new Risorsa[1];
        risorse[0] = r;
    }

    public void acquisizione() {
        for (int pos = 0; pos < risorse.length; pos++) {
            try {
                risorse[pos].getRisorsa();
                Ack(risorse[pos]);
            } catch (InterruptedException e) {
                break;
            }
            finito(risorse[pos]);
        }
    }

    private void Ack(Risorsa risorsa) throws InterruptedException {
        Thread.sleep(1000);
        System.out.println(this.nome + "sta eseguendo " + risorsa.getRisorsa());
    }

    private void finito(Risorsa risorsa) {
        System.out.println(this.nome + " ha terminato " + risorsa.getRisorsa());
    }
}
