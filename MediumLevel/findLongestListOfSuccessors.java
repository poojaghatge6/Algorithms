/*
 * You are given an array of words where each word consists of lowercase English letters.

wordA is a predecessor of wordB if and only if we can insert exactly one letter anywhere in wordA without changing the order of the other characters to make it equal to wordB.

bank = ["a","b","ba","bca","bda","bdca"] ==> 4
["a", "ba", "bda", "bdca"]


["a"]  => ["a"] ==> 1

["", "a","b"] => ["", "a"]

bank = ["ba", "a","b", "bca","bda","bdca"] 


 0  1.  2.   3.   4.    5

 [ "a","b", "ba", "ca", "bca", ]
 
 
O(n^n)

O(n*m)
       
 
word = "a"

curr_index = 1

a

   ba  
   
       bca = []
         
          []
       ["bca"]
   
   ["ba", "bca"]
   
   ca
   
      bca = []
      
      
      ["bca"
      
    ["ca", "bca"]
    
    
["a", "ba", "bca"], [ "a" "ca", "bca"]

   List<word>  findSuccesor (word, bank, current_index) {  a 
   
       List<List<word>> ans  = List
       int cur_length = word.length;

       int i = current_index;
       
       while(bank[i].length == cur_length +1) {
       
          List<words> sucessors = findSuccesor( bank[i], bank, i+1)
      } 
   
   }

  xbxax => "bca"
  
 "a"  ->  "ba" =>{ a : ["a", "ba", "bca"], []},

 
 "b" -> "ba"   =>  b :  ["b", "ba", "bca"], []}
 
  { a : ["a", "ba", "bca"],
    b :  ["b", "ba", "bca"]    
    }

 [ "a","b", "ba", "bd", "bca"]

 [ "a","b", "ba", "bd"]
 
 
 { a : ["a", { "ba", ca } ],

    b :  ["b", "ba"]

  }

smallest_length = 1;

dict = { "a" : ["a"] }

  for (word in i) {
     
     if word is of length smallest 
        dict.add{ word, [word] }
     for  
  }
   isPredecessor()


 */



import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

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

    int max = 0;
      
    List<String> longest;
  
    public List<List<String>> findLongestListOfSccessors( String[] bank) {
       Arrays.sort(bank, (a, b) => {
          return a.length() - b.length();
       });
   
      for(int i=0;i<bank.length; i++) {
        
          findSuccesor(word, bank, i);
              
      }
      return longest;
    }
  
  
    public List<List<String>> findSuccesor(String word, String[] bank, int current_index) {  
   
       List<List<String>> ans  = new ArrayList<List<String>>();
      
       if( current_index > bank.length -1) {
          return ans;
       }
      
       int curr_length = word.length();
       
       int i = current_index;
       
       while(bank[i].length == cur_length +1) {

         if( isSuccesor(word, bank[i]) {
           
           List<List<String>> sucessors = findSuccesor( bank[i], bank, i+1);
          
           for( List<String> path: succesors) {
             path.add(word);
             ans.add(path);
             if(path.size() > max) {
                max = path.size();
                longest = path;
             }
           }
         } 
       }
            
       return ans;
   }
  
   public boolean isSuccesor(String word1, String word2) {
   
   }
  
}
