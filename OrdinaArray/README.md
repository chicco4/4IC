# OrdinaArray
###### Vector sorting + multi threading = :boom:

Vector sorting has been a huge and very dibated problem since the beginning of the computers era.
The first sorting program has been written by John Von Neumann in 1945, the merge sort,
and it's curious that the first sorting program ever written is still today one of the most efficient and stable way to sort an array.

#### Requirements
The request is a comparison between a single thread sorting algorithm and a multi thread one.

#### Implementation
I think that the best solution for this problem is the merge sort, as it's the most intuitive way to sort
an array using a more-than-one-thread solution.

The merge sort splits the original vector into smaller ones and then proceeds to merge them together by putting their elements in the correct order.
I found that the easiest-to-think way to write a multi thread version of this algorithm was to manually split the starting array in half,
assign each half to a different thread and let them perform the merge sort into the given piece of vector.
At the end, the two halves are merged together.

I also tried to start each recursive call to the merge sort method into a new thread, but it turned out to be very time expensive and it
even managed to froze my computer for some seconds before I manually stopped the program.

#### Results
Using the method 
```java
System.nanoTime()
```
I measured the time used by the multi thread merge sort and the single thread merge sort, and in each run the single thread solution took
about 70 times less than the other one, and, in addition to that, its code was much easier to write and much easier to understand.
This because the creation of a new thread is a very onerous operation for the computer to perform, and furthermore we have no way to
control when the second thread will effectively run, as we can only tell the JVM "Hey, this thread is ready to start", but it's the JVM
that pulls the trigger of the starting pistol.

This exercise led me to the conclusion that the best way to sort an array is by using the old single thread solution, that resulted better
than the multi thread one under every point of view

_@author Rossato Francesco_

---

>I don't know why he saved my life. Maybe in those last moments he loved life more than he ever had before.
>Not just his life - anybody's life; my life. All he'd wanted were the same answers the rest of us want.
>Where did I come from?
>Where am I going?
>How long have I got?
>All I could do was sit there and watch him die.

_Deckard, "Blade Runner"_
