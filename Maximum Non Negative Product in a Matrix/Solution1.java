class Pair {
    long min;
    long max;

    Pair(long min, long max) {
        this.min = min;
        this.max = max;
    }
}

class Solution {
    int m;
    int n;
    int MOD = 1_000_000_007;
    Pair[][] dp;
    public int maxProductPath(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        dp = new Pair[m][n];
        Pair res = solve(0, 0, grid);
        return res.max >= 0 ? (int) (res.max % MOD) : -1;
    }

    private Pair solve(int i, int j, int[][] grid) {
        if (i == m - 1 && j == n - 1) {
            return new Pair(grid[i][j], grid[i][j]);
        }

        if (i >= m || j >= n) {
            return null;
        }

        if(dp[i][j] != null) {
            return dp[i][j];
        }

        long minVal = Long.MAX_VALUE;
        long maxVal = Long.MIN_VALUE;

        long ele = grid[i][j];
        Pair right = solve(i, j + 1, grid);
        if (right != null) {
            minVal = Math.min(minVal, Math.min(ele * right.min,ele * right.max));
            maxVal = Math.max(maxVal, Math.max(ele * right.min,ele * right.max));
        }

        Pair down = solve(i + 1, j, grid);
        if (down != null) {
            minVal = Math.min(minVal, Math.min(ele * down.min, ele * down.max));
            maxVal = Math.max(maxVal, Math.max(ele * down.min, ele * down.max));
        }

        return dp[i][j] = new Pair(minVal, maxVal);
    }
}
