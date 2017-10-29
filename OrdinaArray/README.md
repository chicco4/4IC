# Ordina Array
Questo programma confronta l'ordinamento di un array di interi casuali attraverso l'algoritmo merge sort ricorsivo con un singolo thread e con due thread
## Risultato
L'ordinamento con due thread è più efficiente rispetto a quello con un singolo thread solo se l'array supera una lunghezza minima e quindi l'algoritmo richiede un certo tempo per l'esecuzione. Il ché mi porta a pensare che l'ordinamento multithreading (in questo caso, con questa implementazione) di per sé è più efficiente, però la creazione e l'esecuzione di un nuovo thread consuma "molte" risorse e quindi di fatto l'ordinamento multithreading risulta più efficiente solo quando il tempo risparmiato (eseguendo più "compiti" contemporaneamente) supera il tempo impiegato a creare il nuovo thread.
