class Solution {
    public int longestPalindromeSubseq(String s) {
        String s1 = new StringBuilder(s).reverse().toString();

        int n = s.length();
        int[][] dp = new int[n+1][n+1];

        for(int i=n-1;i>=0;i--) {
            for(int j=n-1;j>=0;j--) {
                if(s.charAt(i) == s1.charAt(j)) {
                    dp[i][j] = 1 + dp[i+1][j+1];
                } else {
                    int skipI = dp[i+1][j];
                    int skipJ = dp[i][j+1];

                    dp[i][j] = Math.max(skipI,skipJ);
                }
            }
        }

        return dp[0][0];
    }
}
