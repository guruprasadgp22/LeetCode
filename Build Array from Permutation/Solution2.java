class Solution {
    public int[] buildArray(int[] nums) {
        solve(nums, 0);
        return nums;
    }
    private void solve(int[] nums, int i) {
        if(i < nums.length) {
            int res = nums[nums[i]];
            solve(nums, i+1);
            nums[i] = res;
        }
    }
}
