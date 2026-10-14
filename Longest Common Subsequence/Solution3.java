class Solution {
    int[][] dp;
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        dp = new int[m][n];
        for(int[] x: dp) {
            Arrays.fill(x, -1);
        }
        return solve(m-1, n-1, text1, text2);
    }

    private int solve(int i, int j, String s1, String s2) {
        if(i < 0 || j<0) {
            return 0;
        }

        if(dp[i][j] != -1) {
            return dp[i][j];
        }

        if(s1.charAt(i) == s2.charAt(j)) {
            return dp[i][j] = 1 + solve(i-1,j-1, s1,s2);
        } else {
            return dp[i][j] = Math.max(solve(i-1, j, s1, s2), solve(i,j-1, s1, s2));
        }
    }
}
