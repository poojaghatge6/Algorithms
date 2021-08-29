boolean prefixFreePhones(String[] numbers) {
    
    
  
    Set<String> commonPrefix = new HashSet<String>();
    for(int i=0;i<numbers.length;i++) {
         commonPrefix.add(numbers[i]);
    }
    for(int i =0 ;i< numbers.length; i++) {
        for(String str: commonPrefix) {
            if(!str.equals(numbers[i])) {
                if(str.contains(numbers[i]) || numbers[i].contains(str)  ) return false;
            }
        }
    }
  
    return true;

}
  
boolean checkPrefix(String str1, String str2) {
    
    String smaller = str1.length() > str2.length() ? str2 : str1;
    
    for(int i=0;i<smaller.length();i++) {
        if(str1.charAt(i) != str2.charAt(i)) return false;
    }
    
    return true;
}
