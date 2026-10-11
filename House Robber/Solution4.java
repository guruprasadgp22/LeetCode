class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) {
            return nums[0];
        }

        int[] dp = new int[n];
        dp[n-1] = nums[n-1];
        dp[n-2] = Math.max(nums[n-1], nums[n-2]);

        for(int i=n-3;i>=0;i--) {
            dp[i] = Math.max(nums[i] + dp[i+2], dp[i+1]);
        }

        return dp[0];
    }
}
