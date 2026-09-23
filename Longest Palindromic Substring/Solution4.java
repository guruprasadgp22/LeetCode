class Solution {
    int[][] dp;
    public String longestPalindrome(String s) {
        String ans = "";
        int n = s.length();

        dp = new int[n+1][n+1];
        for(int[] x: dp) {
            Arrays.fill(x, -1);
        }

        for(int i=0;i<n;i++) {
            for(int j=i;j<n;j++) {
                if(((dp[i][j] == 1) || (dp[i][j] == -1 && solve(i, j, s))) && ans.length() < j - i + 1) {
                    ans = s.substring(i, j+1);
                }
            }
        }

        return ans;
    }

    private boolean solve(int i, int j, String s) {
        if(i > j) {
            return true;
        }

        if(dp[i][j] != -1) {
            return dp[i][j] == 1? true: false;
        }

        if(s.charAt(i) == s.charAt(j)) {
            dp[i][j] = solve(i+1, j-1, s)? 1: 0;
            return dp[i][j] == 1? true: false;
        }

        dp[i][j] = 0;
        return false;
    }
}
