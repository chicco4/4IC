# Ravagnan Giacomo 4°IC
# Ordinamento Array con Thread

Creo una classe Sort con vari metodi che permettono di ordinare un'array di int, grazie all'utilizzo di un numero di thread stabilito dall'utente ; ivi indicati i risultati ricavati da varie prove:
    
    1) il numero di thread da utilizzare per una maggiore efficenza è di 6 thread 
    ([qui](ref) si trovano i risultati delle varie prove)
    
    2) inserendo come variabile  threads nel metodo sort un numero maggiore o uguale a 13 il 
    sistema solleverà un'eccezione di tipo "OutOfMemoryError"

La classe Sort contiene vari metodi:

<strong>HalfSort</strong> che permette di pseudo ordinare un'array da una posizione iniziale ad una finale, prendendo il valore medio e spostando i valori minori a sinistra e quelli maggiori a destra, inoltre returna un'int che indica la posizione centrale (che può essere diversa da quella calcolata in precedenza).

<strong>sort</strong> metodo che in modo ricorsivo suddivide l'array originale in due sezioni, destra e sinistra, le quali sono a loro volta suddivise fino ad arrivare al caso base, nel quale le piccole sezioni vengono ordinate con il bubbleSort.

<strong>swap</strong> metodo primitivo che permette di cambiare due posizioni dell'array tra di loro, usato non per meccesità ma solo per un risparmo di righe di codice.

Nel main di prova si usa un metodo:

<strong>HalfSort</strong>
