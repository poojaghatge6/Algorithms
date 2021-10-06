/*
 * Click `Run` to execute the snippet below!
 */

import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.

Q. Boggle is played on a 4x4 grid. Each square on the grid has a letter. The goal is to make as many words as possible by starting anywhere on the board and the moving to any adjacent letters in the grid (horizontally, vertically or diagonally). Given a 4x4 grid and an array containing all valid words, implement an algorithm that returns all the valid words that can be found in the grid.

Examples:
• Given a board:
  [
    'COPS',
    'EDXZ',
    'RLQU',
    'BOKI'
 ]
• And words ['CODE', 'CODER', 'MISSING']
Return ['CODE', 'CODER'] (order does not matter)

 */
 

//  root         [ c,                             m]
//                 o                              i
//                 d                              s
//                 e                             s
//                 r(isEnd = true)                i
//                                                n
//                                                g(isEnd = true)  
   
   
   
   
   
//      [
//         'C OPS',
//         'EDXZ',
//         'RLQU',
//         'BOKI'
//      ]

//   C
  
//    set<>
   
   
//    visited<C>
  
//   o                                   d                                 e
  
//   visited<C, O>                    visited<C, D>                       visited<C, E>
   
//   D
  
//   visited<C, O, D>  
   
   
//   e                                       l      x
  
//    visited<C, O, D, E>  
   
//    set< code>
   
  
   
//    c.            d.       r
   
//                         visited<C, O, D, E, R>  
   
//                         set< code, coder>
                          
     

class TrieNode {


  TrieNode[] children;
  boolean isEnd = false;
  TrieNode (boolean isEnd) {
    
    this.isEnd = isEnd;
    children = new TrieNode[26];
  }
  
}

class Trie {
  
  TrieNode root = null;
  
  Trie() {
    root = new TrieNode(false);
  
  }

  
  
  public boolean search(String word) {
    
    TrieNode curr = root;
    
    for(int i =0; i< word.length() ;i ++ ) {
      
      char ch  = word.charAt(i);
    
      if(curr.children[ch - 'a'] == null) {
        return false;
      } 
      
     
      if(i == word.length()-1) {
          
        
        if( curr.children[ch - 'a'].isEnd == true) {
          System.out.println("returning true");
          return true;
        }
      }
      
        curr  = curr.children[ch - 'a'];
    }
    
    return false;
        
  }
  
  
  public void insert(String word) {
    
    TrieNode curr = root;
    
    for(int i =0; i< word.length() ;i ++ ) {
      
      char ch  = word.charAt(i);
    
      if(curr.children[ch - 'a'] == null) {
      
        curr.children[ch - 'a']  = new TrieNode(false);
      } 
      
     
      if(i == word.length()-1) {
          
        
        curr.children[ch - 'a'].isEnd = true;

      }
      
        curr  = curr.children[ch - 'a'];
    }
        
  }
  
  
  

  
  public boolean startsWith(String prefix) {
    
    
    TrieNode curr = root;
    
    for(int i =0; i< prefix.length() ;i ++ ) {
      
      char ch  = prefix.charAt(i);
    
      if(curr.children[ch - 'a'] == null) {
      
        return false;
      } 
    
    }
    
    return true;
    
  
  }
  
  
  
  public boolean isEnd(TrieNode curr) {
    
    for(int i=0;i<26;i++) {
       if(curr.children[i] != null) return false;
      
    }
    return true;
  
  }
  

  
    
  public TrieNode remove(String word, int depth, TrieNode curr) {
    
    if(curr == null || depth > word.length()-1) return null;
    
    
    
    
    if(depth == word.length()-1) {
      char ch = word.charAt(depth);
        
      curr.children[ch - 'a'].isEnd = false;

      if( isEnd(curr)) {
        return null;
      }
    }
    
    
      char ch = word.charAt(depth);
    
     curr.children[ch-'a'] = remove(word, depth+1, curr.children[ch-'a']);
    
    
     if(curr.isEnd == false && isEnd(curr)) {
      curr = null;
     }  
    
    return curr;
  }
  


}


  

class Solution {
  
  
  
  
  
  public static void main(String[] args) {
    char[][] board = {{'c', 'o', 'p', 's'},
                      {'e', 'd', 'x', 'z'},
                      {'r', 'l', 'q', 'u'},
                      {'b', 'o', 'k', 'i'}};
    
    List<String> words = new ArrayList<>();
    words.add("code");
    words.add("coder");
    words.add("missing");
    
    
    System.out.println(boggleBoard(words, board));
   
  }
  
  
  public static List<String> boggleBoard(List<String> words, char[][] board) {
    
    
     Trie trie = new Trie();
     for(int i=0;i<words.size(); i++) {
      trie.insert(words.get(i));
     }
    
      Set<String> ans_set = new HashSet<>();
    
    List<String> ans = new ArrayList<>();
    
    for(int i=0;i<board.length; i++) {
      for(int j=0;j<board[0].length; j++) {
        System.out.println("checking board[" + i + "][" + j + "]");
        boogleBoardC(i,j,"",trie, new HashSet<Integer>(), ans_set, board);
                                         
      }
    }
    
    ans.addAll(ans_set);
    return ans;
    
    
  
  
  }
  
  
  
  
  
   public static void boogleBoardC(int i, 
                            int j, 
                            String prefix,
                            Trie trie,
                            Set<Integer> visited, 
                            Set<String> ans, 
                            char[][] board) {
     
     if(i<0 || j<0 || j>board[0].length-1 || i> board.length-1) return;
    
      char c = board[i][j];
    
     
     StringBuilder str = new StringBuilder(prefix);
     str.append(Character.toString(c));
     String new_prefix = str.toString();
     
     System.out.println("new_prefix : " + new_prefix + ": old_prefix: " + prefix);
     
     if(trie.startsWith(new_prefix)) {
        
        if(!visited.contains(i*board[0].length + j)) {
          
           visited.add(i*board[0].length + j);
          
          boolean isInTrie = trie.search(new_prefix);
          System.out.println("searched " + new_prefix + ": " + isInTrie);
          if(trie.search(new_prefix)) {
            ans.add(new_prefix);
            System.out.println("added prefix to ans : "+new_prefix + " "+  i+ " "+j);
            trie.root = trie.remove(new_prefix,0, trie.root);
          }
      
        
       
          boogleBoardC(i+1,j,new_prefix, trie, new HashSet<>(visited),  ans, board);
          boogleBoardC(i,j+1,new_prefix, trie, new HashSet<>(visited), ans, board);
          boogleBoardC(i-1,j,new_prefix, trie, new HashSet<>(visited),  ans, board);
          boogleBoardC(i,j-1,new_prefix, trie, new HashSet<>(visited),  ans, board);
        }
  
  
      }
     
   }
  
}






