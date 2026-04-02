class Solution {
    public int maxSubArray(int[] nums) {
        int currentSum = nums[0];
        int maximumSum = nums[0];

        for(int i=1;i<nums.length;i++) {
            currentSum = Math.max(nums[i], nums[i] + currentSum);
            maximumSum = Math.max(currentSum, maximumSum);
        }

        return maximumSum;
    }
}
