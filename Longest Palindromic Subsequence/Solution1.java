class Solution {
    int dp[][];
    public int longestPalindromeSubseq(String s) {
        int n = s.length();

        dp = new int[n+1][n+1];
        for(int[] x: dp) {
            Arrays.fill(x, -1);
        }

        return solve(0, n-1, s);
    }

    private int solve(int i, int j, String s) {
        if(i > j) {
            return 0;
        }

        if(i == j) {
            return dp[i][j] = 1;
        }

        if(dp[i][j] != -1) {
            return dp[i][j];
        }

        if(s.charAt(i) == s.charAt(j)) {
            return dp[i][j] = 2 + solve(i+1, j-1, s);
        } else {
            int skipI = solve(i+1, j, s);
            int skipJ = solve(i, j-1, s);

            return dp[i][j] = Math.max(skipI, skipJ);
        }
    }
}
