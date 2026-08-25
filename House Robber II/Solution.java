class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 0) {
            return 0;
        }

        if(n == 1) {
            return nums[0];
        }

        if(n==2) {
            return Math.max(nums[0], nums[1]);
        }

        return Math.max(solve(nums, 0, n-2), solve(nums, 1, n-1));
    }
    private int solve(int nums[], int start, int end) {
        int n = nums.length;

        int[] dp = new int[n+1];
        dp[0] = nums[start];
        dp[1] = Math.max(nums[start], nums[start + 1]);

        for(int i=start+2, j=2;i<=end;i++, j++) {
            int take = nums[i] + dp[j-2];
            int skip = dp[j-1];
            dp[j] = Math.max(skip ,take);
        }

        return dp[n-2];
    }
}
