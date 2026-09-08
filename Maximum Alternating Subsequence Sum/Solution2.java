class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long[][] dp = new long[n+1][2];
        for(int i=1;i<=n;i++) {
            dp[i][0] = Math.max(dp[i-1][1] - nums[i-1], dp[i-1][0]);
            dp[i][1] = Math.max(dp[i-1][0] + nums[i-1], dp[i-1][1]);
        }

        return Math.max(dp[n][0], dp[n][1]);
    }
}
