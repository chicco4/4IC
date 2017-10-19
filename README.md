##Ragazzo Matteo
#Risorse Condivise

Ho creato una classe Risorsa con solo un costruttore che assegna un nome alla risorsa e crea un nuovo semaforo. Contiene inoltre due metodi acquire e release che eseguono le stesse funzioni sul semaforo creato in precedenza.

Ho successivamente creato una classe Task, che utilizza può utilizzare una o due risorse. 
La funzione run acquisisce i token dei semafori delle risorse che utilizza e dopo aver attesso un tempo random, le rilascia.

Le altre 3 classi : Simul1,2 e 3 utilizzano la classe Task per ricreare tre differenti scenari.
