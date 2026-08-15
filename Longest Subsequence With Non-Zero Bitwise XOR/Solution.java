class Solution {
    public int longestSubsequence(int[] nums) {
        int n = nums.length;
        int resultXor = 0;
        boolean allZero = true;

        for(int ele: nums) {
            resultXor ^= ele;

            if(ele != 0) {
                allZero = false;
            }
        }   

        if(allZero) {
            return 0;
        }

        return resultXor == 0? n-1: n;
    }
}
