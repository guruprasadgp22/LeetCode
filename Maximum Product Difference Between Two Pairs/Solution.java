class Solution {
    public int maxProductDifference(int[] nums) {
        Arrays.sort(nums);

        int maxProduct = nums[nums.length-1] * nums[nums.length-2];
        int minProduct = nums[0] * nums[1];

        return maxProduct - minProduct;
    }
}
