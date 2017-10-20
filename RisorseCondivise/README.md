# Pisciotta Davide
- ## Risorsa:
	- **Semaphore** per controllare l'accesso alla risorsa
- ## Task:
	- **risorse** array dove salva le risorse a cui accedere
	- **run()** il Task accede alla risorsa i-esima, esegue operazioni sulla risorsa appena aperta e su quella precedentemente aperta (se presente), chiude la risorsa precedentemente aperta (se presente), esegue operazioni sulla risorsa appena aperta
