class Solution {
    long[][] dp;
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;

        dp = new long[n][2];
        for(long[] x: dp) {
            Arrays.fill(x, -1);
        }

        int index = 0;
        boolean isEven = true;

        return solve(index, isEven, nums);
    }

    private long solve(int i, boolean isEven, int[] nums) {
        if(i >= nums.length) {
            return 0;
        }

        int j = isEven? 1: 0;
        if(dp[i][j] != -1) {
            return dp[i][j];
        }

        long skip = solve(i+1, isEven, nums);

        int val = nums[i];

        if(isEven == false) {
            val = -val;
        }

        long take = solve(i+1, !isEven, nums) + val;

        return dp[i][j] = Math.max(take, skip);
    }
}
