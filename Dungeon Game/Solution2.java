class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] dp = new int[m][n];
        dp[m-1][n-1] = dungeon[m-1][n-1] <= 0? Math.abs(dungeon[m-1][n-1])+1:1;
        for(int i=m-2;i>=0;i--) {
            int ans = dp[i+1][n-1] - dungeon[i][n-1];
            dp[i][n-1] = ans <= 0? 1: ans;
        } 

        for(int j=n-2;j>=0;j--) {
            int ans = dp[m-1][j+1] - dungeon[m-1][j];
            dp[m-1][j] = ans <= 0? 1: ans;
        }

        for(int i=m-2;i>=0;i--) {
            for(int j=n-2;j>=0;j--) {
                int right = dp[i][j+1];
                int down = dp[i+1][j];
                int ans = Math.min(right, down) - dungeon[i][j];
                dp[i][j] = ans <= 0? 1: ans;
            }
        }

        return dp[0][0];
    }
}
