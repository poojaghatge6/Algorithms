
// https://www.youtube.com/watch?v=L27_JpN6Z1Q

class Solution {
    public int change(int amount, int[] coins) {
        
        
        
        int[][] dp = new int[coins.length][amount+1];
        
        for(int i=0;i<coins.length;i++) {
            dp[i][0] = 1;
        }
        
         for(int j=0;j<=amount;j++) {
             
             if(j%coins[0] == 0) {
                  dp[0][j] = 1;
             } else {
                 dp[0][j] = 0;
             }
           
        }
        
        
         for(int i=1;i<coins.length;i++) {
            for(int j=1;j<=amount;j++) {
                
                if(coins[i] > j) {
                    dp[i][j] = dp[i-1][j];
                    
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i]];
                }
                
            }
        }
        
        return dp[coins.length-1][amount];
        
        
        
        
    }
}
