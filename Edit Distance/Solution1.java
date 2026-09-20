class Solution {
    int m;
    int n;
    int[][] dp;
    public int minDistance(String word1, String word2) {
        m = word1.length();
        n = word2.length();

        dp = new int[m][n];
        for(int[] x: dp) {
            Arrays.fill(x, -1);
        }

        return solve(0, 0, word1, word2);
    }

    private int solve(int i, int j, String s1, String s2) {
        if(i == m) {
            return n-j;
        } else if(j == n) {
            return m-i;
        }

        if(dp[i][j] != -1) {
            return dp[i][j];
        }

        if(s1.charAt(i) == s2.charAt(j)) {
            return dp[i][j] = solve(i+1, j+1, s1, s2);
        } else {
            int insert = 1 + solve(i, j+1, s1, s2);
            int delete = 1 + solve(i+1, j, s1, s2);
            int replace = 1 + solve(i+1, j+1, s1, s2);

            return dp[i][j] = Math.min(insert, Math.min(delete, replace));
        }
    }
}
