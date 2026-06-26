class Solution {
    public int longestSubarray(int[] nums) {
        int start = 0;
        int zeroCount = 0;
        int result = 0;

        for(int end = 0; end < nums.length;end++) {
            if(nums[end] == 0) {
                zeroCount++;
            }

            while(zeroCount > 1) {
                if(nums[start] == 0) {
                    zeroCount--;
                }
                start++;
            }

            result = Math.max(result, end - start + 1);
        }

        return result-1;
    }
}
