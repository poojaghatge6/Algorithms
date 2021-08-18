import java.io.*;
import java.util.*;


class Solution {
 public static void main(String[] args) {
    
   System.out.println(numKTimes(new int[]{1, 2, 3, 3}, 0));
   System.out.println(numKTimes(new int[]{1, 2, 3, 3}, 1));
   System.out.println(numKTimes(new int[]{1, 2, 3, 3}, 2));
   System.out.println(numKTimes(new int[]{1, 2, 3, 3}, 4));

 } 
  public static void display(int [] arr) {
    for(int i =0; i< arr.length ; i++) {
      System.out.print(arr[i]+ " ");
    }
     System.out.println();
  }
  
  public static int numKTimes(int [] arr1, int k) {
   
    int count=0;
    
    HashMap<Integer, Integer> hm = new HashMap<>();
    
    for(int i=0;i<arr1.length; i++) {
      int prev = hm.getOrDefault(arr1[i], 0);
      hm.put(arr1[i], prev+1);
    }
    
    for(Integer key: hm.keySet()) {
      if(hm.get(key) == k) count++;
    }
    return count;
  }
}

