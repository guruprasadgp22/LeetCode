class Solution {
    int total;
    public int subsetXORSum(int[] nums) {
        total = 0;
        solve(nums, 0, 0);
        return total;
    }

    private void solve(int[] nums, int index, int xor) {
        if(index == nums.length){
            total += xor;
            return;
        }

        xor ^= nums[index];
        solve(nums, index+1, xor);
        xor ^= nums[index];
        solve(nums, index+1, xor);
    }
}
