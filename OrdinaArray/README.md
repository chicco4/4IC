Nel progetto OrdinaArray sono presenti 2 classi fondamentali:
-OrdinamentoThread, la quale definisce il metodo run() del thread.
Nel metodo run() infatti l'array da ordinare viene diviso in tanti sottoArray
quanti ne indica il parametro numeroThreads. Una volta che il sottoArray è
stato ottenuto viene ordinato da ogni thread da un tipo di ordinamento scelto.
Io ne ho messo qualcuno come BubbleSort, MergeSort, RadixSort, ecc...
Dopo questo parziale ordinamento viene chiamato il metodo finalSort che esegue 
l'ordinamento finale in base a un algoritmo;
-la classe Sort, che ricevendo l'array da ordinare e il numero di thread scelto, inizializza
l'array di thread e li fa partire.
Dopo alcune prove è emerso che la tecnica migliore è usare 1 solo thread, piuttosto che più thread.
