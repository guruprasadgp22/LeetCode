class Solution {
    int dp[];
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        dp = new int[n];
        Arrays.fill(dp, -1);
        return solve(n-1, cost);
    }

    private int solve(int i, int[] cost) {
        if(i < 1) {
            return 0;
        }

        if(dp[i] != -1) {
            return dp[i];
        }

        int one = cost[i] + solve(i-1, cost);
        int two = cost[i-1] + solve(i-2, cost);

        return dp[i] = Math.min(one, two);
    }
}
