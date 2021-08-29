boolean nestedAnagrams(String s, String t) {
    
    String[] slist = s.split("\\s+");
    String[] tlist = t.split("\\s+");
    
    for(int i=0;i< slist.length; i++) {
        boolean present = false;
        for(int j=0;j< tlist.length; j++) {
            if(isAnagram(slist[i], tlist[j])) {
                present = true;
                // System.out.print(slist[i]+ " "+ tlist[j]);
            }
        }
        if(present == false) return false;
    }
    
    return true;
    

}

boolean isAnagram( String word1, String word2) {
    if(word1.length() != word2.length()) return false;
    
    HashMap<Character, Integer> hm = new HashMap<>();
    
    for(int i =0 ; i<word1.length(); i++) {
        hm.put(word1.charAt(i), hm.getOrDefault(word1.charAt(i), 0) + 1);
    }
    
    for(int i =0 ; i<word2.length(); i++) {
        hm.put(word2.charAt(i), hm.getOrDefault(word2.charAt(i), -1) - 1);
    }
    
    for(Map.Entry<Character,Integer>  ch: hm.entrySet()) {
        if(ch.getValue() != 0) return false;
    }
    
    return true;
}
