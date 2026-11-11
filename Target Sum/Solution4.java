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
        int[] prev = new int[target+1];
        prev[0] = 1;
        for(int i=n-1;i>=0;i--) {
            int[] curr = new int[target+1];
            for(int j=0;j<=target;j++){
                int skip = prev[j];
                int take = 0;
                if(nums[i] <= j) {
                    take = prev[j-nums[i]];
                }

                curr[j] = take + skip;
            }
            prev = curr;
        }
        return prev[target];
    }
}
