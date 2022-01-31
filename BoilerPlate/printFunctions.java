/**
HashMap<String, Set<String>> keyWords
HashMap<String, String> wordKey


sentence1 = ["great","acting","skills"], sentence2 = ["fine","drama","talent"], 

similarPairs = [["great","good"],["fine","good"],["drama","acting"],["skills","talent"]]

great - good

fine - good

good - <fine, great>

drama - acting

acting - drama

skills - talent

talent - skills


start = great, end = find
visited: <great>

next: good
         find
         great
**/

class Solution {
    public boolean areSentencesSimilarTwo(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        
        if(sentence1.length != sentence2.length) {
            return false;
        }
        HashMap<String, Set<String>> keyWords = new HashMap<>();
        HashMap<String, String> wordKey = new HashMap<>();
        //print(similarPairs);
        
        for(List<String> list: similarPairs) {
            Collections.sort(list, (a, b) -> {
                return a.compareTo(b);
            });
        }
        
        Collections.sort(similarPairs, (a, b) -> {
            return a.get(0).compareTo(b.get(0));
        });
        
        // print(similarPairs);

        
        for(List<String> list: similarPairs) {
            String word1 = list.get(0);
            String word2 = list.get(1);
            
            if( wordKey.containsKey(word1) || wordKey.containsKey(word2)) {
                String key1 = wordKey.get(word1);
                String key2 = wordKey.get(word2);
                
                if( key1!= null) {
                  keyWords.get(key1).add(word2); 
                     wordKey.put(word2, key1);
                } else if( key2!= null) {
                   keyWords.get(key2).add(word1); 
                    wordKey.put(word1, key2);
                }
                
            } else {
                keyWords.put(word1, new HashSet<String>());
                keyWords.get(word1).add(word2);
                wordKey.put(word2, word1);
                wordKey.put(word1, word1);
            }
            
            
        }
        
                print(keyWords);
        for(int i = 0; i< sentence1.length; i++) {
            
            String word1 = sentence1[i];
            String word2 = sentence2[i];
            System.out.println(word1 + " word " + word2);
            if( !word1.equals(word2)) {
                String key1 = wordKey.get(word1);
                String key2 = wordKey.get(word2);
                System.out.println(key1 + " key " + key2);
                if(!key1.equals(key2)) {
                    return false;
                }
            }
        
            
        }
        return true;
    }

    public void print(List<List<String>> l) {
        System.out.println();
        for(List<String> list: l) {
            System.out.print("[");
            for(String word: list) {
                System.out.print(word + " ");
            }
            System.out.print("], ");
        }
    }

    public void print(HashMap<String, Set<String>> keyWords) {
        System.out.println();
        for(Map.Entry<String, Set<String>> item: keyWords.entrySet()) {
            System.out.print(item.getKey() +": ");
            for(String word: item.getValue()) {
                System.out.print(word + " ");
            }
            System.out.println();
        }
    }
}
