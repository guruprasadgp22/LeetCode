class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] minEle = new int[n];
        int currMin = Integer.MAX_VALUE;
        for(int i=n-1;i>=0;i--) {
            currMin = Math.min(nums[i], currMin);
            minEle[i] = currMin;
        }

        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++) {
            max = Math.max(max, nums[i]);

            if(max - minEle[i] <= k) {
                return i;
            }
        }

        return -1;
    }
}
