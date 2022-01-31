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


"" -> []

O(4^n)

"23" 
 i
 
 if ( curIndex == "23".length) return ""
 
 
 createComb(0 , "23")
 
     List a + createComb(1 , "23")
     List b + createComb(1 , "23")
     List  c + createComb(1 , "23")


 List


*/
import java.io.*;
import java.util.*;




class Solution {
  public static void main(String[] args) {
    
    List<String> list = phoneCombinations("23");
    print(list);
  }
  
  
    public static void print(List<String> l) {
        System.out.println();
      
            for(String word: l) {
                System.out.print(word + " ");
            }
   
    }
  
  public static  List<String> phoneCombinations(String phoneNumber) {
  
    
    Map<Character, String> map = new HashMap<Character, String>();
    
    map.put('2', "abc"); 
    map.put('3', "def");
    map.put('4', "ghi");
    map.put('5', "jkl");
    map.put('6', "mno");
    map.put('7', "pqrs");
    map.put('8', "tuv");
    map.put('9', "wxyz");
    
    return helper(0, phoneNumber, map);
  
  }
  
  public static List<String> helper(int cur, String phoneNumber, Map<Character, String> map ){
  
    if(cur == phoneNumber.length()) {
      return new ArrayList<String>();
    } else {
      char num = phoneNumber.charAt(cur);
      String letters = map.get(num);
      
      List<String> res = new ArrayList<>();
      
      for( Character c: letters.toCharArray()) { // [ a, b , c] List<>
          
        List<String> list = helper(cur + 1, phoneNumber, map);
        
        if(list.isEmpty()) {
          res.add(String.valueOf(c));
        }
        for(String comb: list) {
          res.add( c + comb);
        }
      
      }
      
      return res;

    }
  }
}
