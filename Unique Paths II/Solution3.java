class Solution {
    int m;
    int n;
    int[][] dp;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        m = obstacleGrid.length;
        n = obstacleGrid[0].length;
        if(obstacleGrid[m-1][n-1] == 1) {
            return 0;
        }
        dp = new int[m][n];
        for(int[] x: dp) {
            Arrays.fill(x, -1);
        }
        return solve(m-1,n-1,obstacleGrid);
    }

    private int solve(int i, int j, int[][] grid) {
        if(i == 0 && j == 0 && grid[i][j] == 0) {
            return 1;
        }

        if(i < 0 || j< 0 || grid[i][j] == 1) {
            return 0;
        }

        if(dp[i][j] != -1) {
            return dp[i][j];
        }

        return dp[i][j] = solve(i-1, j, grid) + solve(i, j-1, grid);
    }
}
