/* 

Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.

Note that after backspacing an empty text, the text will continue empty.
 
Example 1:
Input: s = "ab#c", t = "ad#c"
Output: true
Explanation: Both s and t become "ac".

Example 2:
Input: s = "ab##", t = "c#d#"
Output: true
Explanation: Both s and t become "".

Example 3:
Input: s = "a#c", t = "b"
Output: false
Explanation: s becomes "c" while t becomes "b".


s = "##ab" yes valid


t = "ab"

true

string builder 

all lowercase

time and space O(n+m)


 0 1 2       0 1 2 


int lastEqualIdx = 3, firstHash = 2, c = 2, lastUnequalIndex = -1

 0 1 2 3         0 1 2 3        
"& & & & c v b", t = " c #  # c d s"
  
  
  int lastEqualIdx = 1, firstHash = -1, c = 1, lastUnequalIndex = 2
 
  0 1 2        0
 "a # c", t = "b"
 
   int lastEqualIdx = 1, firstHash = -1, c = 0, lastUnequalIndex = 5
 
 " a b c x y z # # #",  " m n o"
  
  
  
     ab#c
    
        
        
      if one of them becomes out of bounds then go only till backspaces are still there
      
      
      
      end:
  
      
      lastEqualIdx  < lastUnequalIndex
         return false
      

set_indices : { }


        0 1 2 3
 ##ab   ab##
i       j


 
 

*/



import java.io.*;
import java.util.*;

class Solution {
  public static void main(String[] args) {
  
    
    System.out.println(checkEquals("##ab", "ab##")); // false
    System.out.println(checkEquals("#a#b", "b")); // true
    System.out.println(checkEquals("ab#c", "ad#c")); // true
    System.out.println(checkEquals("ab##", "c#d#")); // true
    
    System.out.println(checkEquals("a#c", "b")); // false
    
    
//     System.out.println(checkEquals("ab#c", "ad#c")); // true
//     System.out.println(checkEquals("ab##", "c#d#")); // true
    
//     System.out.println(checkEquals("a#c", "b")); // false
    
  }
  
  
  
  public static boolean checkEquals(String s, String t) {
    int i = s.length() - 1, j = t.length() - 1;
    
    while( i >= 0 && j >= 0) {
    
        char ch1 = s.charAt(i);
        char ch2 = t.charAt(j);
      
        if(ch1 == '#' || ch2 == '#') {
          int k = i;
          while(k >= 0 && s.charAt(k) == '#') {
            k--;
            i = i - 2;
          }
          int m = j;
          while(m >= 0 && t.charAt(m) == '#') {
             m--;
             j = j - 2;
          }
    
        } else {
           if(ch1 != ch2) {
              return false;
           }
           i--;
           j--;
        }
    }
    
    if( i> -1 ) {
      if(s.charAt(i) != '#') return false;
      i--;
    }
    if( j> -1 ) {
      if(t.charAt(j) != '#') return false;
      j--;
    }
    return true;
  }
  
/*

  public boolean backspaceCompare(String S, String T) {
      int i = S.length() - 1, j = T.length() - 1, back;
      while (true) {
          back = 0;
          while (i >= 0 && (back > 0 || S.charAt(i) == '#')) {
              back += S.charAt(i) == '#' ? 1 : -1;
              i--;
          }
          back = 0;
          while (j >= 0 && (back > 0 || T.charAt(j) == '#')) {
              back += T.charAt(j) == '#' ? 1 : -1;
              j--;
          }
          if (i >= 0 && j >= 0 && S.charAt(i) == T.charAt(j)) {
              i--;
              j--;
          } else {
              break;
          }
      }
      return i == -1 && j == -1;
  }


*/
  
  
  
}

