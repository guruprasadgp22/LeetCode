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
        return solve(n, target, nums);
    }

    private int solve(int i, int target, int[] nums) {
        if(i == 0) {
            return target == 0? 1: 0;
        }

        int skip = solve(i-1, target, nums);
        int take = 0;
        if(nums[i-1] <= target) {
            take = solve(i-1, target-nums[i-1], nums);
        }

        return skip + take;
    }
}
