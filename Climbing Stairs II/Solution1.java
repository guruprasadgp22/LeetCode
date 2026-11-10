class Solution {
    int[] dp;
    public int climbStairs(int n, int[] costs) {
        dp = new int[n+1];
        Arrays.fill(dp, -1);
        return solve(0, n, costs);
    }

    private int solve(int i, int n, int[] costs) {
        if (i > n) {
            return 0;
        }
        
        if(dp[i] != -1) {
            return dp[i];
        }

        int result = 0;
        if (i + 1 <= n) {
            int j = i + 1;
            result = costs[j - 1] + (j - i) * (j - i) + solve(j, n, costs);
        }
        if (i + 2 <= n) {
            int j = i + 2;
            result = Math.min(result, costs[j - 1] + (j - i) * (j - i) + solve(j, n, costs));
        }
        if (i + 3 <= n) {
            int j = i + 3;
            result = Math.min(result, costs[j - 1] + (j - i) * (j - i) + solve(j, n, costs));
        }
        return dp[i] = result;
    }
}
