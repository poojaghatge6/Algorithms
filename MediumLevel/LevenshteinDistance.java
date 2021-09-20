import java.util.*;

class Program {
  public static int levenshteinDistance(String str1, String str2) {
    // Write your code here.
		int[][] E = new int[str1.length() + 1][str2.length() + 1];
		
		for(int r=0; r<=str1.length(); r++) {
			for(int c=0; c<=str2.length(); c++) {
				if(r==0) {
					E[r][c] = c;
				} else if(c==0) {
					E[r][c] = r;
				} else if( str1.charAt(r-1) == str2.charAt(c-1)) {
					E[r][c] = E[r-1][c-1];
				} else {
					E[r][c] = 1+ Math.min( E[r][c-1], Math.min(E[r-1][c-1], E[r-1][c]) );
				}
			}
		}
		return E[str1.length() ][str2.length()];
  }
}
