# Ragazzo Matteo

## Esercizio MaxThread

Ho creato una classe MaxArray che oridina un array, dato un punto di inizio e un punto di fine. Alla fine aggiunte il risultato in un ArrayList.

Ho creato un'altra classe chiamata GetMax che, dato un array e un numero n, ordina l'array tramite n Thread. Ogni volta che un Thread si interrompe, chiama il metodo CountDown() della classe CountDownLatch. Quanto il CountDown arriva a 0 (tutti i Thread hanno trovato il massimo), viene trovato il massimo tra l'ArrayList dei risultati.

Nella classe Main creò un array di MAX elementi, lo riempo di numeri random (e il stampo)e poi chiamo utilizzo la classe GetMax per trovare il numero maggiore.

In alcuni casi il programma si interrompe con errori ogni volta diversi, non capisco quale sia il problema.
