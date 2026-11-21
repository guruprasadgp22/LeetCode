class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int curr = 0;
        int left = 0;
        int maxLen = Integer.MAX_VALUE;
        for(int right = 0; right < nums.length; right++) {
            curr += nums[right];

            while(left <= right && curr >= target) {
                maxLen = Math.min(maxLen, right - left + 1);
                curr -= nums[left];
                left++;
            }
        }

        return maxLen == Integer.MAX_VALUE? 0: maxLen;
    }
}
