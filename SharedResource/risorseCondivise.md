# RisorseCondivise

Le seguenti figure rappresentano tre diverse situazioni per due thread che condividono una o due risorse non condivisibili.  
![st08 svg](https://user-images.githubusercontent.com/8972836/31275301-07b37360-aa97-11e7-8b74-88cae8389a5e.png)  
In questo primo caso i due thread non possono usare la risorsa non condivisibile in contemporanea (zona V) e quindi non possono entrare in zona vietata.  
![st09 svg](https://user-images.githubusercontent.com/8972836/31275302-07bad36c-aa97-11e7-8437-96218298b074.png)  
In questo secondo caso ogni singolo thread usa due risorse e vie è un momento in cui le usa entrambe, ma i due tread accedono in modo analogo alle risorse (prima la prima risorsa e poi la seconda).
![st10 svg](https://user-images.githubusercontent.com/8972836/31275303-07c86162-aa97-11e7-8040-eeccfa9ab2ef.png)  
In quest'ultimo caso i thread accedono in modo diverso alle risorse (in ordine opposto): non possono accedere ad alcune zone (zona I) e si intrappolano in altre (zona T) dando luogo ad un **deadlock**.  
Viene realizzata la classe
```
Task
```
che rappresenta il compito (`Runnable`) di un singolo thread. Tale classe accederà alle risorse. La classe
```
Risorsa
```
realizza mediante un semaforo binario (un solo permits) la risorsa. Le tre figure saranno illustrate mediante simulazione rispettivamente nei file
```
Simul1.java
Simul2.java
Simul3.java
```
Un file
```
README.md
```
per la documentazione in cui apparirà il proprio nome. Mettere il tutto nella directory
```
RisorseCondivise
``` 
