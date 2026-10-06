class Solution {
    int m;
    int n;
    int[][] dp;
    public int longestIncreasingPath(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;

        dp = new int[m][n];
        for(int[] x: dp) {
            Arrays.fill(x, -1);
        }

        int maxLen = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxLen = Math.max(maxLen, solve(i, j, matrix));
            }
        }

        return maxLen;
    }

    private int solve(int i, int j, int[][] matrix) {
        if(dp[i][j] != -1) {
            return dp[i][j];
        }

        int maxLen = 1;

        if (i - 1 >= 0 && matrix[i][j] < matrix[i - 1][j]) {
            maxLen = Math.max(maxLen, 1 + solve(i - 1, j, matrix));
        }

        if (j - 1 >= 0 && matrix[i][j] < matrix[i][j - 1]) {
            maxLen = Math.max(maxLen, 1 + solve(i, j - 1, matrix));
        }

        if (i + 1 < m && matrix[i][j] < matrix[i + 1][j]) {
            maxLen = Math.max(maxLen, 1 + solve(i + 1, j, matrix));
        }

        if (j + 1 < n && matrix[i][j] < matrix[i][j + 1]) {
            maxLen = Math.max(maxLen, 1 + solve(i, j + 1, matrix));
        }

        return dp[i][j] = maxLen;
    }
}
