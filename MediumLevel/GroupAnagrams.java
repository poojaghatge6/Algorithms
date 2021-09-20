import java.util.*;

class Program {
  public static List<List<String>> groupAnagrams(List<String> words) {
    // Write your code here.
    HashMap<String, List<String>> hm = new HashMap<String, List<String>>();
		
		for(int i=0;i< words.size();i++) {
			  char tempArray[] = words.get(i).toCharArray();
        Arrays.sort(tempArray);
        String sorted = new String(tempArray);
			  List<String> temp = hm.getOrDefault(sorted, 
																			 new ArrayList<String>()
																			);
			  temp.add(words.get(i));
			  hm.put(sorted, temp);
		}
		
		List<List<String>> ans = new ArrayList<>();
		
		
		for(Map.Entry<String, List<String>> tuple: hm.entrySet()) {
			ans.add(tuple.getValue());
		}
		
	  return ans;
  }
}
