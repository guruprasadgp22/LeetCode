class Solution {
    int MOD = 1_000_000_007;
    public int numberOfSets(int n, int k) {
        int[][] dp = new int[k+1][n+1];
    	
    	for(int i=0;i<=n;i++) {
    		dp[0][i] = 1;
    	}
    	
    	for(int i=1;i<=k;i++) {
            int[] prevRowSum = new int[n+1];
            for(int x= n-1;x>=0;x--) {
                prevRowSum[x] = (prevRowSum[x+1] + dp[i-1][x]) % MOD;
            }
    		for(int j=n-1;j>=0;j--) {
    			int skip = dp[i][j+1];
    			int take = prevRowSum[j+1];
    			dp[i][j] = (take + skip) % MOD;
    		}
    	}
    	
    	return dp[k][0];
    }
}
