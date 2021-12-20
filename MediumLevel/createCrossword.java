/*

Given a dictionary of n words each of length k, a valid crossword solution to this is an k*k matrix, where each column and each row forms a word in the dictionary.  

Given a dictionary, and a solution of the crossword, write a function to check if the solution is a valid solution

Example input:
dictionary: ["owe", "cot", "cat", "ten", "awe", "car"] m

        k*k

            c o t
            o o o
            o o o 
            
           return matrix;
        
      
      placement ( row, matrix[][], dict)
      
         
         if(row == matrix.length) {
            if(isValidCrossword(matrix, dict)) {
                globalMatrix = matrix
            
            }
         }
         for ( word in dict) {
         
            fill the matrix row with word;
            
            placement( row+1, matrix, dict)
         }
         
         return;

              c o t
              a w e
              t e n
               
set        
            
input solution:     [['c', 'o', 't'],
                     ['a', 'w', 'e'],
                     ['t', 'e', 'n']]   
                     
              
                  cot   false 

Result: True

space : O(1)

Time: O Max(k*k, m*k)



input ( dict, matrix) -> o/p if any word is present or not

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
    
    String[] words = new String[] { "owe", "cot", "cat", "ten", "awe", "car"};
      HashSet<String> dict = new HashSet<>();
    
    for( String word: words) {
      
      dict.add(word);
    }
    
    char[][] matrix = new char[][] {  {'c', 'o', 't'},
                                    {'a', 'w', 'e'},
                                    {'t', 'e', 'n'}    };
    
    System.out.println(isValidCrossword(dict, matrix));
    
    char[][] matrix1 = generateCrossword(dict, 3);
    
    for(int row = 0; row< matrix1.length; row++) {
      for(int col = 0; col< matrix1[0].length; col++) {
        System.out.print( matrix1[row][col] + " ") ;
      }
       System.out.println();
    } 
  }
  
  public static boolean isValidCrossword(Set<String> dict, char[][] matrix) {
  
    for(int row = 0; row< matrix.length; row++) {
      StringBuilder sb = new StringBuilder();
      for(int col = 0; col< matrix[0].length; col++) {
         sb.append(matrix[row][col]);
      }
      if(!dict.contains(sb.toString())) {
        return false;
      }
    }

    for(int col = 0; col < matrix[0].length; col++) {
      StringBuilder sb = new StringBuilder();
      for(int row = 0; row < matrix.length; row++) {
         sb.append(matrix[row][col]);
      }
      if(!dict.contains(sb.toString())) {
        return false;
      }
    }
    return true;
  
  }
  
  public static char[][] globalMatrix = null;
  
  
  public static char[][] generateCrossword( Set<String> dict, int k) {
     char[][] matrix = new char[k][k];
     placement(0, matrix, dict);
     return globalMatrix;
  }
  
  
  public static void print(char[][] matrix) {
      for(int row = 0; row< matrix.length; row++) {
          for(int col = 0; col< matrix[0].length; col++) {
            System.out.print( matrix[row][col] + " ") ;
          }
          System.out.println();
      }
  }
  

  public static void placement( int row, char[][] matrix, Set<String> dict) {
        if(row == matrix.length) {
            if(isValidCrossword(dict, matrix)) {
                globalMatrix = matrix;
                print(matrix);
                System.exit(0);
            }
           return;
         }
    
         for (String word: dict) {
            for( int col = 0; col < matrix[0].length; col++ ) {
               matrix[row][col] = word.charAt(col);
            }
            placement( row+1, matrix, dict);
         }
         return;
  }
  
}

