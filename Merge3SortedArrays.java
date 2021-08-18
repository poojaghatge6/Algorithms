import java.io.*;
import java.util.*;


class Solution {
 public static void main(String[] args) {
    int arr1[] = new int[] {1, 2};
    int arr2[] = new int[] {3, 4};
    int arr3[] = new int[] {5, 6};
    int [] merged = mergeLists(arr1, arr2, arr3);
    display(merged);
   
    arr1 = new int[] {1, 2, 10};
    arr2 = new int[] {2, 9};
    arr3 = new int[] {11};
    merged = mergeLists(arr1, arr2, arr3);
    display(merged);
   
    arr1 = new int[] {1, 3};
    arr2 = new int[] {2, 6};
    arr3 = new int[] {4, 5};
    merged = mergeLists(arr1, arr2, arr3);
    display(merged);
   
    arr1 = new int[] {};
    arr2 = new int[] {1, 2};
    arr3 = new int[] {};
    merged = mergeLists(arr1, arr2, arr3);
    display(merged);
   
    arr1 = new int[] {1, 2, 3, 4};
    arr2 = new int[] {1, 2, 3, 4};
    arr3 = new int[] {1, 2, 3, 4};
    merged = mergeLists(arr1, arr2, arr3);
    display(merged);
   
    arr1 = new int[] {};
    arr2 = new int[] {};
    arr3 = new int[] {};
    merged = mergeLists(arr1, arr2, arr3);
    display(merged);
 } 
  public static void display(int [] arr) {
    for(int i =0; i< arr.length ; i++) {
      System.out.print(arr[i]+ " ");
    }
    
     System.out.println();
  }
  public static int[] mergeLists(int [] arr1, int [] arr2, int [] arr3) {
    
    int i=0, j=0, k=0, l=0;
    int ans[] = new int[arr1.length+arr2.length+arr3.length];
    
    while(i< arr1.length || j<arr2.length || k<arr3.length) {
      
      int v1 = i< arr1.length ? arr1[i] : Integer.MAX_VALUE;
      int v2 = j< arr2.length ? arr2[j] : Integer.MAX_VALUE;
      int v3 = k< arr3.length ? arr3[k] : Integer.MAX_VALUE;

      int num = Math.min(v3, Math.min(v1,v2));
      
      if(num == v1) {
        ans[l++] = arr1[i++];
      } else if(num == v2) {
        ans[l++] = arr2[j++];
      } else if(num == v3) {
        ans[l++] = arr3[k++];
      }
    }
    return ans;
  }
  
}
