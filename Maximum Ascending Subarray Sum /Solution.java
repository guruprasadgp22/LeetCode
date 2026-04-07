class Solution {
    public int maxAscendingSum(int[] nums) {
        int curr = nums[0];
        int ans = 0;

        for(int i=1;i<nums.length;i++) {
            if(nums[i-1] < nums[i]) {
                curr += nums[i];
            } else {
                ans = Math.max(ans, curr);
                curr = nums[i];
            }
        }

        return Math.max(curr, ans);
    }
}
