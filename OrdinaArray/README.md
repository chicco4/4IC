Nel progetto OrdinaArray sono presenti 2 classi fondamentali:
-OrdinamentoThread, la quale crea il thread vero e proprio e contiene
varie proprietà come il numero di thread, la lunghezza del sottoArray, il sottoArray,
l'array da ordinare e una variabile d'appoggio.
L'array viene suddiviso in tante parti quante ne indica il numero di thread scelto e
successivamente ogni thread ordina la sua parte, da qui il sottoArray.
I metodi per questi ordinamenti possono essere vari tra cui BubbleSort, RadixSort, MergeSort, ecc...
Infine il thread riunisce in un array tutti i sottoArray e ordina completamente l'array grazie anche alla classe Sort;
-Sort, una classe che invece implementa un solo metodo (sort) che inizializza e fa partire tutti i thread iniziando quindi la sequenza di ordinamento.
Nel main la chiamata al metodo sort ha 2 parametri: l'array da ordinare e il numero di thread.
