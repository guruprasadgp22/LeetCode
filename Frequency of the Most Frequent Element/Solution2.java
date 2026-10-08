class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        int right = 0;
        long currentSum = 0;
        int result = 0;

        while(right < nums.length) {
            long target = nums[right];
            currentSum += nums[right];

            long windowSum = (right - left + 1) * target;
            long op = windowSum - currentSum;
            while(left < right && op > k) {
                currentSum -= nums[left];
                left++;
                windowSum = (right - left + 1) * target;
                op = windowSum - currentSum;
            }

            result = Math.max(result, right - left + 1);
            right++;
        }

        return result;
    }
}
