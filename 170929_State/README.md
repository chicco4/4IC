## IPOTESI

> Il thread inizializzati accedono allo stato new , al richiamo del metodo .start(); si sposta nello stato READY
> alla quale la schedular decide di prendere il thread (prende prima quelli in base alla convenienienza) e di spostarlo nello stato RUNNING
> Il nostro thread durante lo stato RUNNING puo accedere a tre stati diversi "WAITING" "TIMED WAITING" E "BLOCKED"
> col metodo td.join(); il nostro thread va in attesa fino a quando il Thread td non va nello stato TERMINATED (ovvero ha finito il metodo run(); o é stato stoppato)
> per stampare lo stado del metodo in attesa bloccato nel metodo join , non ho fatto altro che creare una classe osservatore che implementa un'interfaccia :
> Osservatore che permette di accedere a metodi che concedono di modificare l'oggetto da osservare e metodi che permettono di stampare l'aggiornamento;
> Mentre l'intefaccia Osserato che va data alla classe che viene osservato che permette di impostare da chi farsi osservare, o notificare l'eventuale aggiornamento.

## DOCUMENTAZIONE

### Documentazione lavoro

> Creazione della classe Watcher
* creato costruttore con due istanze (Thread Data , Thread Network);
* creati i metodi toString di entrambi i Thread;
* creato metodo run, il quale esegue le operazioni di visualizzazione dei cambiamenti dei thread;

> commento1: il seguente programma trova dei problemi quando si cerca di cambiare il delay del download simulato, ma non essendo richiesto l'ho ritenuto marginale, ipotizando che si trattasse di una valore fisso.

> commento2: nell'ultimo update del sorgente ho creato un ciclo for dove cerco i cambiamenti di stato, funzionante con qualsiasi delay

![Alt Text](https://i.imgur.com/nd79U4B.png)