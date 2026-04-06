class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int curr = 1;
        int ans = 0;
        int n = nums.length;

        for(int i=0;i<n-1;i++) {
            if(nums[i] < nums[i+1]) {
                curr++;
            } else {
                ans = Math.max(curr, ans);
                curr = 1;
            }
        }
        ans = Math.max(ans, curr);

        for(int i=n-1;i>=1;i--) {
            if(nums[i] < nums[i-1]) {
                curr++;
            } else {
                ans = Math.max(curr, ans);
                curr = 1;
            }
        }

        return Math.max(ans, curr);

    }
}
