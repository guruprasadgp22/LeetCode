class Solution {
    public boolean hasValidPath(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        if(grid[0][0] == ')' || grid[m-1][n-1] == '(' || (m+n-1) % 2 == 1){
            return false;
        }

        boolean[][][] dp = new boolean[m][n][m+n];

        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                for(int count =0;count<=i+j+1;count++) {
                    if(i==m-1 && j==n-1){
                        dp[i][j][count] = count == 0;
                    }

                    if(i+1 < m){
                        int next = grid[i+1][j] == '('? count+1:count-1;
                        if(next >= 0 && dp[i+1][j][next]){
                            dp[i][j][count] = true;
                        }
                    }

                    if(j+1 < n){
                        int next = grid[i][j+1] == '('? count+1: count-1;
                        if(next >=0 && dp[i][j+1][next]) {
                            dp[i][j][count] = true;
                        }
                    }
                }
            }
        }

        return dp[0][0][1];
    }
}
