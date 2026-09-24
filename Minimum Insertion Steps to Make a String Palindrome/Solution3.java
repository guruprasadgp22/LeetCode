class Solution {
    public int minInsertions(String s) {
        int n = s.length();

        int[][] dp = new int[n+1][n+1];

        for(int len = 2; len <= n; len++) {
            for(int i=0;i+len<=n;i++) {
                int j = i + len - 1;

                if(i >= j) {
                    dp[i][j] = 0;
                } else if(s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i+1][j-1];
                } else {
                    dp[i][j] = Math.min(1 + dp[i][j-1], 1 + dp[i+1][j]);
                }
            }
        }

        return dp[0][n-1];
    }
}
