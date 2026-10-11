class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) {
            return nums[0];
        }
        int[] dp = new int[n];
        int prevPrev = nums[0];
        int prev = Math.max(nums[0], nums[1]);
        int result = prev;

        for(int i=2;i<n;i++) {
            result = Math.max(prev, prevPrev + nums[i]);
            prevPrev = prev;
            prev = result;
        }

        return result;
    }
}
