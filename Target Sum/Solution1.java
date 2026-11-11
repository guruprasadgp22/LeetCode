class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int ele: nums) {
            sum += ele;
        }

        target = Math.abs(target);
        if((sum + target)% 2 != 0) {
            return 0;
        }

        target = (target + sum)/2;
        return solve(0, target, nums);
    }

    private int solve(int i, int target, int[] nums) {
        if(i == nums.length) {
            return target == 0? 1: 0;
        }

        int skip = solve(i+1, target, nums);
        int take = 0;
        if(nums[i] <= target) {
            take = solve(i+1, target-nums[i], nums);
        }

        return take + skip;
    }
}
