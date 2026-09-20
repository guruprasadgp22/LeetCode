class Solution {
    int m;
    int n;
    int[][] dp;
    public int minDistance(String word1, String word2) {
        m = word1.length();
        n = word2.length();
        
        dp = new int[m+1][n+1];
        for(int[] x: dp) {
            Arrays.fill(x, -1);
        }

        return solve(m, n, word1, word2);
    }

    private int solve(int i, int j, String s1, String s2) {
        if(i == 0) {
            return j;
        } else if(j == 0) {
            return i;
        }

        if(dp[i][j] != -1) {
            return dp[i][j];
        }

        if(s1.charAt(i-1) == s2.charAt(j-1)) {
            return dp[i][j] = solve(i-1, j-1, s1, s2);
        } else {
            int insert = 1 + solve(i, j-1, s1, s2);
            int delete = 1 + solve(i-1, j, s1, s2);
            int replace = 1 + solve(i-1, j-1, s1, s2);

            return dp[i][j] = Math.min(insert, Math.min(delete,  replace));
        }
    }
}
