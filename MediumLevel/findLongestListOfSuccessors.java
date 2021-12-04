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
