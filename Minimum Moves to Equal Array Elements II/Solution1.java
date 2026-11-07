class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int mid = nums[nums.length/2];
        int op = 0;
        for(int ele: nums) {
            op += Math.abs(mid - ele);
        }
        return op;
    }
}
