# Ordina Array

L'ordinamento di array di interi è un classico problema di programmazione procedurale (BubbleSort, MergeSort ecc.). In questo home work proponiamo di ordinare un array di interi in modo concorrente (utilizzando più thread). Invitiamo a valutare sulla macchina i vantaggi, se ve ne sono, di questa tecnica rispetto ad una (la migliore?) che usi un singolo thread. Lo studente usi il metodo
```
public static long nanoTime()
```
per valutare i tempi ([qui](https://docs.oracle.com/javase/7/docs/api/java/lang/System.html#nanoTime()) la documentazione).