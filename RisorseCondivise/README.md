# RisorseCondivise
In **RisorseCondivise** è presente una classe **Task** che implemetenta l' interfaccia **Runnable**, una classe **Risorsa** e tre 
simulazioni. La classe **Task** contiene il metodo **run()** che consente, al **thread** corrente, di acquisire e rilasciare una risorsa. 
La classe **Risorsa** è la classe i cui oggetti sono appunto le risorse che i **thread** utilizzano. Inoltre la classe **Risorsa** contiene 
un **semaphore** per la gestione ed il permesso all' accesso delle risorse.
1. Prima simulazione: due **thread** utilizzano una sola risorsa condivisa, non condivisibile (ovvero non possono utilizzarla entrambi i 
**thread** contemporanemente), e quindi i due **thread** non possono entrare in una **zona vietata**, zona in cui utilizzererebbero appunto 
la  stessa risorsa nello stesso momento.
2. Seconda simulazione: i due **thread** utilizzando due diverse risorse **resourse1** & **resourse2**. C' è un momento in cui i **thread** 
utilizzano entrambe le risorse, ma accedendo sempre nell' ordine **resourse1** e **resourse2**.
3. Terza simulazione: Stessa cosa della simulazione precedente a parte per il fatto che uno dei due **thread** accede prima alla 
**resourse2** e poi alla **resourse1**, dando luogo ad un **deadlock**. Si crea anche una zona **inutilizzata**, zona in cui i **thread** 
non entreranno mai.
