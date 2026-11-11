class Solution {
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
        int[][] dp = new int[n+1][target+1];
        dp[n][0] = 1;
        for(int i=n-1;i>=0;i--) {
            for(int j=0;j<=target;j++){
                int skip = dp[i+1][j];
                int take = 0;
                if(nums[i] <= j) {
                    take = dp[i+1][j-nums[i]];
                }

                dp[i][j] = take + skip;
            }
        }
        return dp[0][target];
    }
}
