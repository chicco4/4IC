Commento TestDataDownload


Un thread in fase di esecuzione, può passare allo stato: 
1)Quando il programma fà partire il metodo .start() il thread passa dallo stato NEW allo stato ready ed inseguito 
allo stato RUNNABLE.
2)TIMED_WAITING quando viene utilizato il metodo sleep();
3)WAITING quando viene utilizzato il metodo .join();
4)BLOCKED quando un thread deve aspettare un particolare evento entra in stato blocked 
(salvando i registri utente, il program counter e lo stack pointer).
5)SBLOCCO quando si verifica l'evento per cui il processo era stato posto in stato blocked, il thread passa allo stato ready.
6)TERMINATED quando un thread completa il suo compito, il suo contesto per i registri e i suoi stack vengono deallocati.


Dentro la classe osservatore ho inserito un metodo update() che ha lo scopo di osservare ogni secondo lo stato di un thread inserito da parametro.



