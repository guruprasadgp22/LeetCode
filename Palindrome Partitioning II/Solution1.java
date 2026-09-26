class Solution {
    public int minCut(String s) {
        int n = s.length();
        boolean[][] palindrome = new boolean[n][n];
        for(int len = 1; len <=n ;len++) {
            for(int i=0;i+len <= n; i++) {
                int j = i + len -1;
                if(i == j) {
                    palindrome[i][j] = true; 
                } else if(i + 1 == j) {
                    palindrome[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    palindrome[i][j] = (s.charAt(i) == s.charAt(j) && palindrome[i+1][j-1]);
                }
            }
        }

        int[] dp = new int[n];
        for(int i=0;i<n;i++) {
            if(palindrome[0][i]) {
                dp[i] = 0;
            } else {
                dp[i] = Integer.MAX_VALUE;
                for(int k=0;k<i;k++) {
                    if(palindrome[k+1][i] && 1 + dp[k] < dp[i]) {
                        dp[i] = 1 + dp[k];
                    }
                }
            }
        }

        return dp[n-1];
    }
}
