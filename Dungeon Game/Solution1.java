class Solution {
    int m;
    int n;
    int[][] dp;
    public int calculateMinimumHP(int[][] dungeon) {
        m = dungeon.length;
        n = dungeon[0].length;
        dp = new int[m][n];
        for(int[] x: dp) {
            Arrays.fill(x, -1);
        }
        return solve(0, 0, dungeon);
    }

    private int solve(int i, int j, int[][] arr) {
        if(i == m -1 && j == n-1) {
            int returnVal = arr[i][j] <= 0? Math.abs(arr[i][j]): 0;
            return returnVal + 1;
        }

        if(i >= m|| j>= n) {
            return Integer.MAX_VALUE;
        }

        if(dp[i][j] != -1) {
            return dp[i][j];
        }

        int right = solve(i, j+1, arr);
        int down = solve(i+1, j, arr);
        int ans = Math.min(right, down) - arr[i][j];

        return dp[i][j] = ans<= 0? 1: ans;
    }
}
