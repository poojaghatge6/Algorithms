/* 
Prompt: 

Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

'2' -> 'abc' 
'3' -> 'def'
'4' -> 'ghi'
'5' -> 'jkl'
'6' -> 'mno'
'7' -> 'pqrs'
'8' -> 'tuv'
'9' -> 'wxyz'

Function Signature: func phoneCombinations(input: String) -> [String]  

Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

*/


/*
https://leetcode.com/problems/longest-consecutive-sequence/

 * Click `Run` to execute the snippet below!
 */

import java.io.*;
import java.util.*;

/*
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 
 [1,2,3,5,6] -> [1,2,3] -> 3
 
 
  [1,4,2,5,3] -> [1,2,3,4,5] -> 5
  
  mark index: (num - 1) as present
  
  set: 1, 4, 
  
   [1,4,2,5,3] 
    0 1 3 4 5
    
    O(n)
    
    
    nlogk
    
    
    
    [1,4,2,5,3] 
    
    head 1 -> 2 -> 3 -> 4 -> 5 , len = 5
    
    head 4 -> 5 ,  2
    
  
    set {1, 4, 2}
    
    
  
    
    set of start indexes  dict <key, node>
    
    1 -> 2 -> 3 <- -> 4 -> 5
    
    another start node with value (3+1) 
    
    
    
    dict<Integer, Node> start_indexes
    
    HashMap<Integer, Node> end_indexes
    
    
    
    

   
   
   {3, 3} 3

   {5, 2} 4
   
   
   1,2,3,4
   
   
  
  HashMap<Key, Len>
  
  
  len = 2
  
  
  mapped [1, 1, 1, 1, 1]
          0. 1. 2  3. 4
  
  
  max_len[] 
  
  last_num[] 
  
  
  [1, 3] max_len = 2, last_num= 2
  
  3
  
  5 
  
  7
  
  [ 4, 5] max_len= 2, 5
  
  
  
  space: O(n)
  
  
  
  
  
  
  1 2 3 6 7 8 
  
  
  
  
  len = 1
  
  max
  
  
  nlon(n)
 space O(1)
 
 
 
 
 
 */

class Node {
  
  Node prev;
  Node next;
  int val;
  int len;
  
  Node(int val, Node prev, Node next, int len) {
    this.val = val;
    this.prev = prev;
    this.next = next;
    this.len = len;
  }
}


class Solution {
  public static void main(String[] args) {
    ArrayList<String> strings = new ArrayList<String>();
    strings.add("Hello, World!");
    strings.add("Welcome to CoderPad.");
    strings.add("This pad is running Java " + Runtime.version().feature());

    for (String string : strings) {
      System.out.println(string);
    }
  }
  
  
  public int longestSubsequence(int[] arr) {
   
    HashMap<Integer, Node > dict = new HashMap<Integer, Node>();
    int max = Integer.MIN_VALUE;
    
    for(int i: arr) {
      
      Node curr = new Node(i, null, null, 1);
    
      if(dict.containsKey( i-1)) {
      
        Node prev = dict.get(i-1);
        
        prev.next = curr;
        
        curr.prev = prev;
        
        curr.len = prev.len + 1;
        
        prev.len = curr.len;
        
      } 
      
    // let me create a new google meet https://meet.google.com/ixh-kuch-kcq
      // https://meet.google.com/ixh-kuch-kcq
      
      
      // i cant hear you
      
      if(dict.containsKey( i+1)) {
        Node next = dict.get(i+1);
        
        next.prev = curr;
        
        curr.next = next;
        
        curr.len = next.len - ; // ? len
        
      } 
        
      dict.put(i, curr);
      
      
    
      
    } 
    
  
  }
  
}


//  [1,4,2,5,3] 
 

//  1, 1 }  {2 , 2}   {3 3 }
   
  
//   4 2 5 2















