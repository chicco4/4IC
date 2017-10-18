Il progetto RisorseCondivise contiene la classe Risorsa 
che contiene un nome (String) e un permesso binario 
(Semaphore) ed essa, quando viene acquisita, dura 5 sec.
Sono presenti inoltre le classi Task e TaskConArrayRisorse:
la classe Task lavora con 1 o max 2 risorse mentre la 
classe TaskConArrayRisorse lavora intuitivamente con un array
di risorse.
Nelle simulazioni dell'andamento dei thread si può vedere
come i thread debbano "attendersi" per accedere alle risorse.
Utilizzando TaskConArrayRisorse Simul1 e Simul2 sono identiche 
se non uguali, prendendo le risorse e aspettando.
Nella Simul3 invece i thread arrivando nella zona T e si 
aspettano a vicenda creando un deadlock.
Fortunato Francesco