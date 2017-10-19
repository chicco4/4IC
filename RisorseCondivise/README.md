## Ragazzo Matteo
# Risorse Condivise

Ho creato una classe Risorsa con un solo costruttore che assegna un nome alla risorsa e crea un nuovo semaforo. La classe contiene inoltre due metodi: acquire e release, che eseguono le omonime funzioni sul semaforo creato in precedenza.

Ho successivamente creato una classe Task, che può utilizzare una o due risorse (assegnate tramite il costruttore). 
La funzione run acquisisce i token dei semafori delle risorse che utilizza e dopo aver attesso un tempo "random", le rilascia.

Le altre 3 classi : Simul1,Simul2 e Simul3 utilizzano la classe Task per ricreare tre differenti scenari.
