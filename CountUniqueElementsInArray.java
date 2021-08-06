import java.io.*;
import java.util.*;

class CountUniqueElementsInArray {
 public static void main(String[] args) {
    int arr[] = new int[] {3, 1, 1, 2, 3, 1, 1, 1, 4};
    
   
    System.out.println(numUniques(arr));
    System.out.println(numUniques(new int[]{}));
    System.out.println(numUniques(new int[]{1}));
    
 } 

  public static int numUniques(int [] arr) {
    Set<Integer> unique = new HashSet<>();
    
    for(int i =0; i< arr.length;i++) {
      unique.add(arr[i]);
    }
    
    return unique.size();
    
   
  } 

  
}
