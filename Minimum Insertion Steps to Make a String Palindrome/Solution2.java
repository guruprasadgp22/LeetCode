class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        int[][] dp = new int[n+1][n+1];

        for(int i=n-1;i>=0;i--) {
            for(int j=0;j<n;j++) {
                if(i >= j) {
                    dp[i][j] = 0;
                } else if(s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i+1][j-1];
                } else {
                    dp[i][j] = Math.min(1 + dp[i+1][j], 1 + dp[i][j-1]);
                }
            }
        }

        return dp[0][n-1];
    }
}
