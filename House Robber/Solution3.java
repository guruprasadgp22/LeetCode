class Solution {
    int[] dp;
    public int rob(int[] nums) {
        int n = nums.length;
        dp = new int[n];
        Arrays.fill(dp, -1);
        return solve(n-1, nums);
    }

    private int solve(int i, int[] nums) {
        if(i < 0) {
            return 0;
        }

        if(dp[i] != -1) {
            return dp[i];
        }

        int skip = solve(i-1, nums);
        int take = nums[i] + solve(i-2, nums);
        return dp[i] = Math.max(skip, take);
    }
}
