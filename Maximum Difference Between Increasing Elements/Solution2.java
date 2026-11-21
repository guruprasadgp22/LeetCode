class Solution {
    public int maximumDifference(int[] nums) {
        int n = nums.length;
        int j = 1;
        int minEle = nums[0];
        int maxDiff = -1;

        while(j < n) {
            if(nums[j] > minEle) {
                maxDiff = Math.max(maxDiff, nums[j] - minEle);
            } else {
                minEle = nums[j];
            }
            j++;
        }
        return maxDiff;
    }
}
