/*
 * Click `Run` to execute the snippet below!
 */

import java.io.*;
import java.util.*;

/*
# Largest Consecutive Sum
# Given an array of integers, return the maximum consecutive sum you can find in the array. You can start summing at any index, stop summing at any index but you can’t skip indexes. The sum you return has to be the maximum you can find in the array.

# Examples:
# [3, 1, -1, 8, -5] => 11
# [3, 1, -5, 8, -5] => 8
# [-1, -2, -4] => 0


 
[3, 1, -1, 8, -5] => 11
  
 3 4  3  11 6 
         i
         
         

           l
  
  MaxSum which would keep track of max sum as we go
  add new num top the sum only when cum sum + new num is > curr num
  
  
 [-1, -2, -4]     
 
  -1 

[] => 0
  
  -1 0 +ve
  
  
   [3, 1, -5, 8, -5] => 8
  
cumSum = 3
  
  
   [3, 1, -5, 8, -5] => 8
  
    3  4  -1  8   3
  
  maxSoFar = 8
  
  O(n)
  
  O(1)
  
 cumSum = -1
  
  [-1, -2, -4] => 0
   -1  -2  -4
   
   maxSoFar = 0
   
   
   */


/*
# Next Permutation
# Given an array of distinct characters, find the next permutation in dictionary order. In-place is fine.

# Note 1: A permutation is a fancy term for a rearrangement. The desired output should have the same elements as in the input, but in another order. It may help to think in terms of member-preserving operations, like swapping elements or sorting.
# Note 2: Dictionary order, also known as lexicographical order, is using element by element comparisons to compare two arrays as a whole. It's akin to determining whether "tier" or "tire" comes first in a dictionary.
# Note 3: We don't need to know all subsequent permutations - just the immediate successor. There are multiple permutations that sort after [1, 3, 2], and the earliest of those is [2, 1, 3].

# The permutations of [1, 2, 3]:
# [1, 2, 3] => [1, 3, 2]
# [1, 3, 2] => [2, 1, 3]
# [2, 1, 3] => [2, 3, 1]
# [2, 3, 1] => [3, 1, 2]
# [3, 1, 2] => [3, 2, 1]

next bigger num
// [1, 2, 3]


# Some larger examples:
# [2, 1, 4, 5, 3] => [2, 1, 5, 3, 4]


# [2, 1, 5, 3, 4] => [2, 1, 5, 4, 3]
# [2, 1, 5, 4, 3] => [2, 3, 1, 4, 5]


found = false;


# [6, 2, 5, 4, 3, 1] => ?
                
               i     arr.length
                  
          for i = arr.length to 0
             
              for( j = i + 1, arr.length)
                  if( arr[i] > arr[j] )
                     {
                       swap(i, j}
                       
                       i+1 to arr.length
                    
                     }
  
  
  
               [3 1]
            [4 3 1]
        [5 4 3 1]
         
      [2 5 4 3 1]   curr num with the next highest num 
        
       i           sorted the rem numbers to append it to curr num 
                   once i find next then append with prev nums
                   return the result
         [3 5 4 2 1] 
         
         [2 5 4 3 1]  
         
      6 3 1 2 4 5
      
      
      
      

[2, 1, 4, 5, 3]  

     
     

            [3]
         [5 3]
         
      [5 4 3]
      
  2 1  5 3 4]
  
  

[2, 1, 4, 5, 3] 

2 1 4 5 3.  2 1 4 3 5  x
 
 2 1 5 3 4 correct  

duplicate number => no


*/

class Solution {
  public static void main(String[] args) {
    int[] arr = new int[]{ 3, 1, -5, 8, -5 }; //8
    int[] arr1 = new int[]{ 3, 1, -1, 8, -5 }; // 11
    int[] arr2 = new int[]{ -1, -2, -4}; // 0
    int[] arr3 = new int[]{};
    
    int[] arr4 = new int[]{0, -9};
    
    System.out.println(largestConsecutiveSum(arr));
    System.out.println(largestConsecutiveSum(arr1));
    System.out.println(largestConsecutiveSum(arr2));
    
    System.out.println(largestConsecutiveSum(arr3));
    System.out.println(largestConsecutiveSum(arr4));
    
    
    int[][] inputs = new int[][] { {2, 1, 4, 5, 3}, {6, 2, 5, 4, 3, 1} };
    
    for(int[] input: inputs) {
        
       int[] res = nextPerm(input);
       print(res);
      
    }
  }
  
  public static void print( int[] input) {
     System.out.println();
     for(int i: input) {

         System.out.print(i + " ");

      }
  }
  
  public static int largestConsecutiveSum(int[] arr) {
    int maxSoFar = 0, cumSum = 0;
    for(int i = 0; i < arr.length; i++) {
      if(cumSum + arr[i] > arr[i]) {
        cumSum = cumSum + arr[i];
      } else {
        cumSum = arr[i];
      }
      maxSoFar = Math.max( maxSoFar, cumSum );
    }
    return maxSoFar;
  }
  
  public static int[] nextPerm ( int[] arr) {
  
    for(int i = arr.length - 1;  i >= 0; i--) {
    
       for(int j = i + 1;  j < arr.length - 1; j++) {
            
           if( arr[j] > arr[i] ) {
           
              int temp = arr[i];
              arr[i] = arr[j];
              arr[j] = temp;
              System.out.println( i + " i");
              return sort(arr, i + 1);
           }
       }
    }
    
    return null;
  }
  
  
//    5 6 7 9
//      i  
//        i+1 n
         
     
//    0 to i
     
//    6 7 9 5
  public static int[] sort(int[] arr, int start) {
  
//       for(int i = start; i < arr.length - 1; i++) {
      
//         for( int j = i + 1; j < arr.
    
    // Arrays.s
            
     Arrays.sort(arr, start, arr.length - 1);
     return arr;
  
  }
  
  
  
  
  
}
