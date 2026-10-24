class Solution {
    int m;
    int n;
    int[][] dp;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        m = obstacleGrid.length;
        n = obstacleGrid[0].length;
        dp = new int[m][n];
        for(int[] x: dp) {
            Arrays.fill(x, -1);
        }
        return solve(0, 0, obstacleGrid);
    }

    private int solve(int i, int j, int[][] arr) {
        if(i == m-1 && j == n-1 && arr[i][j] == 0) {
            return 1;
        }

        if(i >=m || j>= n || arr[i][j] == 1) {
            return 0;
        }

        if(dp[i][j] != -1) {
            return dp[i][j];
        }

        return dp[i][j] = solve(i+1, j, arr) + solve(i, j+1, arr);
    }
}
