class Pair {
    long min;
    long max;

    Pair(long min, long max) {
        this.min = min;
        this.max = max;
    }
}

class Solution {
    public int maxProductPath(int[][] grid) {
        int MOD = 1_000_000_007;
        int m = grid.length;
        int n = grid[0].length;
        Pair[][] dp = new Pair[m][n];

        dp[m - 1][n - 1] = new Pair(grid[m - 1][n - 1], grid[m - 1][n - 1]);

        for (int i = m - 2; i >= 0; i--) {
            int ele = grid[i][n - 1];
            dp[i][n - 1] = new Pair(ele * dp[i + 1][n - 1].min, ele * dp[i + 1][n - 1].max);
        }

        for (int j = n - 2; j >= 0; j--) {
            int ele = grid[m - 1][j];
            dp[m - 1][j] = new Pair(ele * dp[m - 1][j+1].min, ele * dp[m - 1][j+1].max);
        }

        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                long ele = grid[i][j];

                long minVal = Long.MAX_VALUE;
                long maxVal = Long.MIN_VALUE;

                Pair right = dp[i][j + 1];
                if (right != null) {
                    minVal = Math.min(minVal, Math.min(right.min * ele, right.max * ele));
                    maxVal = Math.max(maxVal, Math.max(right.min * ele, right.max * ele));
                }

                Pair down = dp[i + 1][j];
                if (down != null) {
                    minVal = Math.min(minVal, Math.min(down.min * ele, down.max * ele));
                    maxVal = Math.max(maxVal, Math.max(down.min * ele, down.max * ele));
                }

                dp[i][j] = new Pair(minVal, maxVal);
            }
        }

        Pair res = dp[0][0];
        return res.max >= 0? (int)(res.max % MOD): -1;
    }
}
