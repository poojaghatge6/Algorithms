import java.util.*;

class Program {
  public static List<Character> longestCommonSubsequence(String str1, String str2) {
    // Write your code here.
		
		StringBuilder[][] dp = new StringBuilder[str1.length()+1][str2.length()+1];
		StringBuilder temp = null;
		List<Character> ans = new ArrayList<>();
		for(int i=0;i<=str1.length();i++) {
			for(int j=0;j<=str2.length() ; j++) {
				 
				 if(i==0 || j==0) {
					 dp[i][j] = new StringBuilder("");
				 } else {
					 
					 char ch1 = str1.charAt(i-1);
					 char ch2 = str2.charAt(j-1);
					 if(ch1 == ch2) {
						 temp = dp[i-1][j-1];
						 // temp.append(ch1);
						 dp[i][j] = new StringBuilder(temp);
						 dp[i][j].append(ch1);
					 } else {
						 
						 if(dp[i-1][j].length() > dp[i][j-1].length()) {
							 temp =  dp[i-1][j];
							 dp[i][j] = new StringBuilder(temp);
						 } else {
							 temp =  dp[i][j-1];
							 dp[i][j] = new StringBuilder(temp);
						 }
						 
					 }
					 
				 }
			}
			
		}
		
		String ansStr = dp[str1.length()][str2.length()].toString();
		for(int j=0;j<ansStr.length() ; j++) {
			
				ans.add(ansStr.charAt(j));
			
		}
		
    return ans;
  }
}
