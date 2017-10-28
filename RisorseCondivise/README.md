# SharedResource
###### You made my program got stuck

There are three exercises: 
* **[Simul1](https://github.com/zuccante/4IC/blob/rossatofrancesco/RisorseCondivise/src/Simul1.java)**, in which there are two threads who try to gain access to the same shared resource, and each one waits until the other one finishes using it.
* **[Simul2](https://github.com/zuccante/4IC/blob/rossatofrancesco/RisorseCondivise/src/Simul2.java)**, in which there are two threads who try to gain access to the same two resources in the same order, and each one waits until the other one finishes using them
* **[Simul3](https://github.com/zuccante/4IC/blob/rossatofrancesco/RisorseCondivise/src/Simul3.java)**, the most interesting case, in which there are two threads who try to gain access to the same two resources with different order. This means that you may experience a deadlock if the threads gets trapped into the zone of no return.

All the shared resources are of the **Semaphore** class.

_@author Rossato Francesco_

>It matters not how strait the gate, 
>
>How charged with punishments the scroll, 
>
>I am the master of my fate,
>
>I am the captain of my soul. 

_William Ernest Henley, "Invictus"_
