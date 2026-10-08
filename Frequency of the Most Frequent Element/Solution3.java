class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);

        int left = 0;
        int right = 0;
        long currentSum = 0;
        int result = 0;

        while(right < nums.length) {
            currentSum += nums[right];

            if((long)(right - left + 1) * nums[right] - currentSum > k) {
                currentSum -= nums[left];
                left++;
            }

            result = Math.max(result, right - left + 1);
            right++;
        }

        return result;
    }
}
