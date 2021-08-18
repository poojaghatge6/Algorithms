import java.io.*;
import java.util.*;

class InsertionSort {
 public static void main(String[] args) {
    int arr[] = new int[] {-10, 1, 3, 8, -13, 32, 9, 5};
    
    int [] sorted = insertionSort(arr);
    display(sorted);
    
 } 
  public static void display(int [] arr) {
    for(int i =0; i< arr.length ; i++) {
      System.out.print(arr[i]+ " ");
    }
  }
   public static int[] insertionSort(int [] arr) {
      
    for(int i=0;i<arr.length-1;i++) {
        
        if(arr[i+1] >= arr[i]) continue; 
      
        int temp = arr[i+1];
        int j =i;
        
        for(j=i;  j>=0 && arr[j]>temp; j--) {
            arr[j+1] = arr[j];
        }
          
        if(j>=0 && temp > arr[j]) {
            arr[j+1] = temp;
        } else if(j<0) {
            arr[0] = temp;
        }
      
    }
    
    return arr;
    
  }
    
}
