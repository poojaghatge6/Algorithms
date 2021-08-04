import java.io.*;
import java.util.*;

class Solution {
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
    
    int i= 0, j = 0;
    for( i=0; i<arr.length-1; i++) {
      for( j=i+1; j<arr.length && arr[j]>=arr[i]; j++) {
        i++; 
      }
      if(arr[j]< arr[i] && j< arr.length) insert(arr, i, j, arr[j]);
 
    }
    return arr;
  } 

  public static void insert(int [] arr, int end, int ele_pos, int ele) {
    int j=ele_pos;
    for(j=ele_pos-1; j>=0 && ele <= arr[j]; j--) {
       arr[j+1] = arr[j];
    }

    if(j>=0 && ele > arr[j]) {
      arr[j+1] = ele;
    } else if(j<0) {
      arr[0] = ele;
    }
  }
}
