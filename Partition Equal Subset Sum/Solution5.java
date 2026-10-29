class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int ele: nums) {
            sum += ele;
        }

        if(sum % 2 == 1) {
            return false;
        } 
        sum /= 2;
        boolean[][] dp = new boolean[n+1][sum+1];
        for(int i=0;i<=n;i++) {
            dp[i][0] = true;
        }

        for(int i=1;i<=n;i++) {
            for(int j=0;j<=sum;j++){
                boolean take = false;
                if(nums[i-1] <= j) {
                    take |= dp[i-1][j-nums[i-1]];
                }
                boolean skip = dp[i-1][j];
                dp[i][j] = skip | take;
            }
        }

        return dp[n][sum];
    }
}
