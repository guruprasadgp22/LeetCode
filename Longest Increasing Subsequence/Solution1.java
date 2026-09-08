class Solution {
    int[][] dp;
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        dp = new int[n+1][n+1];
        for(int[] x: dp) {
            Arrays.fill(x, -1);
        }

        int i=0;
        int prevIdx = -1;

        return solve(i, prevIdx, nums);
    }

    private int solve(int i, int prevIdx, int[] nums) {
        if(i >= nums.length) {
            return 0;
        }

        int newPrevIdx = prevIdx + 1;
        if(dp[i][newPrevIdx] != -1) {
            return dp[i][newPrevIdx];
        }

        int skip = solve(i+1, prevIdx, nums);

        int take = 0;
        if(prevIdx == -1 || nums[prevIdx] < nums[i]) {
            take = 1 + solve(i+1, i, nums);
        }

        return dp[i][newPrevIdx] = Math.max(skip, take);
    }
}
