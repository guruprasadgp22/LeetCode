class Solution {
    int[] dp;
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        dp = new int[n+1];
        Arrays.fill(dp, -1);
        return Math.min(solve(0, cost), solve(1, cost));
    }

    private int solve(int i, int[] cost) {
        if(i >= cost.length) {
            return 0;
        }       

        if(dp[i] != -1) {
            return dp[i];
        }

        int first = cost[i] + solve(i+1, cost);
        int second = cost[i] + solve(i+2, cost);
        return dp[i] = Math.min(first, second);
    }
}
