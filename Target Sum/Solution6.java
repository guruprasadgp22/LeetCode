class Solution {
    int[][] dp;
    public int findTargetSumWays(int[] nums, int target) {
        target = Math.abs(target);
        int sum = 0;
        for(int ele: nums) {
            sum += ele;
        }

        if((sum + target) % 2 != 0) {
            return 0;
        }

        target = (sum + target)/2;
        int n = nums.length;
        dp = new int[n+1][target+1];
        for(int[] x: dp) {
            Arrays.fill(x, -1);
        }
        return solve(n, target, nums);
    }

    private int solve(int i, int target, int[] nums) {
        if(i == 0) {
            return target == 0? 1: 0;
        }

        if(dp[i][target] != -1) {
            return dp[i][target];
        }

        int skip = solve(i-1, target, nums);
        int take = 0;
        if(nums[i-1] <= target) {
            take = solve(i-1, target-nums[i-1], nums);
        }

        return dp[i][target] = skip + take;
    }
}
