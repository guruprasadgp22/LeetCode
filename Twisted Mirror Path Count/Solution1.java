class Solution {
    int m;
    int n;
    int MOD = 1_000_000_007;
    int[][][] dp;
    public int uniquePaths(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        dp = new int[m][n][2];
        for(int[][] x: dp) {
            for(int[] y: x) {
                Arrays.fill(y, -1);
            }
        }
        return solve(0, 0, 0, grid);
    }

    private int solve(int i, int j, int come, int[][] grid) {
        if(i >= m || j >= n) {
            return 0;
        }

        if(i == m- 1 && j == n-1) {
            return 1;
        }

        if(dp[i][j][come] != -1) {
            return dp[i][j][come];
        }

        if(grid[i][j] == 1) {
            if(come == 0) {
                return dp[i][j][come] = solve(i+1, j, 1, grid);
            } else {
                return dp[i][j][come] = solve(i, j+1, 0, grid);
            }
        }

        return dp[i][j][come] = (solve(i+1, j, 1, grid) + solve(i, j+1, 0, grid))%MOD;
    } 
}
