class Solution {
    int[][] dp;
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        dp = new int[m][n];
        for(int[] x: dp) {
            Arrays.fill(x, -1);
        }

        int i = 0;
        int j = 0;
        return solve(i, j, text1, text2);    
    }

    private int solve(int i, int j, String text1, String text2) {
        if(i >= text1.length() || j >= text2.length()) {
            return 0;
        }

        if(dp[i][j] != -1) {
            return dp[i][j];
        }

        int take = 0;
        if(text1.charAt(i) == text2.charAt(j)) {
            take = 1 + solve(i+1, j+1, text1, text2);
        }

        int skipI = solve(i+1, j, text1, text2);
        int skipJ = solve(i, j+1, text1, text2);

        return dp[i][j] = Math.max(take, Math.max(skipI, skipJ));
    }
}
