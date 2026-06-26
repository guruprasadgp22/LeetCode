class Solution {
    public long countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        int len = 2 * n + 2;

        long[] commulativeSum = new long[len];
        long[] countAtSum = new long[len];
        int index = n+1;
        commulativeSum[index] = 1;
        countAtSum[index] = 1;

        long ans = 0;

        for(int num: nums) {
            if(num == target) {
                index++;
            } else {
                index--;
            }

            countAtSum[index]++;
            ans += commulativeSum[index-1];
            commulativeSum[index] = commulativeSum[index-1] + countAtSum[index];
        }

        return ans;
    }
}
