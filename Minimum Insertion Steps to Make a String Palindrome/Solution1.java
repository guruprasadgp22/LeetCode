class Solution {
    int[][] dp;
    public int minInsertions(String s) {
        int n = s.length();
        dp = new int[n+1][n+1];
        for(int[] x: dp) {
            Arrays.fill(x, -1);
        }
        return solve(0, s.length()-1, s);
    }

    private int solve(int i, int j, String s) {
        if(i >= j) {
            return 0;
        }

        if(dp[i][j] != -1) {
            return dp[i][j];
        }

        if(s.charAt(i) == s.charAt(j)) {
            return dp[i][j] = solve(i+1, j-1, s);
        } else {
            int skipI = 1 + solve(i+1, j, s);
            int skipJ = 1 + solve(i, j-1, s);

            return dp[i][j] = Math.min(skipI, skipJ);
        }
    }
}
