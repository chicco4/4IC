/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordinamento;

/**
 *
 * @author FortuF100
 */
public class BubbleSort {
    private static int[] x;
    public static void bubbleSort(int[] val) 
    {
    x = val;
    int temp = 0;
    int j = x.length-1;
    while(j>0) 
      {
      for(int i=0; i<j; i++) 
        {
        if(x[i]>x[i+1])  
          {
          temp=x[i]; 
          x[i]=x[i+1];
          x[i+1]=temp;
          }
        }
      j--; 
      }
    }
}
