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
        int[][] prev = new int[n+1][target+1];
        prev[0][0] = 1;

        for(int i=1;i<=n;i++) {
            for(int j=0;j<=target;j++) {
                int skip = prev[i-1][j];
                int take = 0;
                if(nums[i-1] <= j) {
                    take = prev[i-1][j-nums[i-1]];
                }
                prev[i][j] = take + skip;
            }
        }

        return prev[n][target];
    }
}
