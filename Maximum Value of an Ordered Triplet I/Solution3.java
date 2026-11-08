class Solution {
    public long maximumTripletValue(int[] nums) {
        long result = 0;
        int maxDiff = 0;
        int maxI = 0;
        for(int i=0;i<nums.length;i++) {
            result = Math.max(result, (long)maxDiff * nums[i]);
            maxDiff = Math.max(maxDiff, maxI - nums[i]);
            maxI = Math.max(maxI, nums[i]);
        }

        return result;
    }
}
