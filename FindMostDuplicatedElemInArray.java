import java.io.*;
import java.util.*;


class Solution {
 public static void main(String[] args) {
    
  System.out.println(findMostDupe(new int[]{1}));
  System.out.println(findMostDupe(new int[]{1, 2, 2, 1, 2, 3, 2, 1}));
  System.out.println(findMostDupe(new int[]{1, 1, 1}));
  System.out.println(findMostDupe(new int[]{3, 2, 1, 3}));

    
 } 
  public static void display(int [] arr) {
    for(int i =0; i< arr.length ; i++) {
      System.out.print(arr[i]+ " ");
    }
    
     System.out.println();
  }
  
  public static int findMostDupe(int [] arr1) {
   
    int count=Integer.MIN_VALUE;
    int ele=Integer.MIN_VALUE;
    
    HashMap<Integer, Integer> hm = new HashMap<>();
    
    for(int i=0;i<arr1.length; i++) {
      
      int prev = hm.getOrDefault(arr1[i], 0);
      
      hm.put(arr1[i], prev+1);
      
    }
    
    for(Integer key: hm.keySet()) {
      if(hm.get(key) > count) {
        count = hm.get(key);
        ele = key;
      }
    }
    return ele;
  }
    
  
}
