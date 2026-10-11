class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) {
            return nums[0];
        }
        int prevPrev = nums[n-1];
        int prev = Math.max(nums[n-1], nums[n-2]);
        int result = prev;

        for(int i=n-3;i>=0;i--) {
            result = Math.max(nums[i] + prevPrev, prev);
            prevPrev = prev;
            prev = result;
        }

        return result;
    }
}
