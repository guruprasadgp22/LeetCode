class Solution {
    public int minInsertions(String s) {
        int n = s.length();

        String s1 = new StringBuilder(s).reverse().toString();

        int[][] dp = new int[n+1][n+1];
        for(int i=n-1;i>=0;i--) {
            for(int j=n-1;j>=0;j--) {
                if(s.charAt(i) == s1.charAt(j)) {
                    dp[i][j] = 1 + dp[i+1][j+1];
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j+1]);
                }
            }
        }

        return n - dp[0][0];
    }
}
