# --Ordinamento Multitreading-- README.md 
### [ Autor : Cappellato Pietro](https://github.com/ObZenTish)

> In this version of the code I preferred to use a multi-thread sort, that is, when inserting the array to be ordered, the thread divided it into two subarrays, which reordered them, then refused them in the starting array and executed a new sort

 @Override
 public void run() {
 
        int i = 0;
        int[] num1 = null;
        int[] num2 = null;
        while (i < num.length / 2) {
            num1[i] = num[i];
            i++;
        }
        i = num.length;
        while (i < num.length) {
            num2[i] = num[i];
            i++;
        }
        thread.quicksort(num1);
        thread.quicksort(num2);
        int j = 0;
        while (j < num1.length) {
            num[j] = num1[j];
            j++;
        }
        int k = j;
        while (k < num2.length * 2) {
            num[k] = num2[k];
            k++;
        }
        thread.quicksort(num);
    }
    
I use quicksorting only for example, works for any sorting system described [above](https://github.com/ObZenTish/TPSIT_4IC/tree/master/OrdinaArray)
_____________________________________________________________________________________

### SOURCE

> **[DOCS ORACLE](https://docs.oracle.com/javase/7/docs/api/java/lang/System.html#nanoTime())**

_____________________________________________________________________________________

> I've done it... now give me my f##king Netflix.
> **ObZenTish's Brain**

![Imgur](http://i.imgur.com/5Ltz1EH.gif)
