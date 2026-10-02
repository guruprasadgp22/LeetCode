class Solution {
    int m;
    int n;
    int[][][] dp;
    public boolean hasValidPath(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        
        dp = new int[m+1][n+1][201];
        for(int[][] x: dp) {
            for(int[] y: x) {
                Arrays.fill(y, -1);
            }
        }

        if(grid[0][0] == ')' || grid[m-1][n-1] == '(' || (m+n-1) % 2 == 1) {
            return false;
        }

        return solve(0, 0, 0, grid);
    }

    private boolean solve(int i, int j, int count, char[][] grid) {
        count += (grid[i][j] == '(')? 1: -1;
        if(count < 0) {
            return false;
        }

        if(dp[i][j][count] != -1) {
            return dp[i][j][count] == 1? true: false;
        }

        if(i == m-1 && j == n-1){
            boolean ans = count == 0;
            dp[i][j][count] = ans? 1: 0;
            return ans;
        }

        if(i+1 < m && solve(i+1, j, count, grid)){
            dp[i][j][count] = 1;
            return true;
        }

        if(j+1 < n && solve(i, j+1, count, grid)){
            dp[i][j][count] = 1;
            return true;
        }

        dp[i][j][count] = 0;
        return false;
    }
}
