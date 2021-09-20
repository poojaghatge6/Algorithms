class TrieNode {
    
     // R links to node children
    public TrieNode[] children;

    public boolean isEnd;

    TrieNode(boolean isEnd) {
        children = new TrieNode[26];
        this.isEnd = isEnd;
    }

    
}



class Trie {
    
 
   TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode(false);
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
      
      TrieNode curr = root;
      
      for(int i=0 ;i < word.length(); i++) {
        
        char ch = word.charAt(i);
         
         if(curr.children[ch - 'a'] == null) {
            curr.children[ch -  'a'] = new TrieNode(false);
         }
         if( i == word.length() -1) {
             
             if(curr.children[ch -  'a'] == null) {
                 curr.children[ch -  'a'] = new TrieNode(true); 
             } else {
                  curr.children[ch -  'a'].isEnd = true;
             }
           
         }
        
        curr = curr.children[ch -  'a'];
      
      }
        
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
      TrieNode curr = root;
      for(int i=0 ;i < word.length(); i++) {
          char ch = word.charAt(i); 
          if(curr.children[ch - 'a'] == null) {
            return false;
          }
         
          curr = curr.children[ch -  'a'];
           if(i== word.length() -1) {
               if(curr.isEnd == true) return true;
               else return false;
          }
      }
      return true;   
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
      
      
      TrieNode curr = root;
      for(int i=0 ;i <prefix.length(); i++) {
        
          char ch = prefix.charAt(i); 
          if(curr.children[ch - 'a'] == null) {
            return false;
          }
         
    
         curr = curr.children[ch -  'a'];
        
      }
      
      return true;
      
        
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
