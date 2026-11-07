class Solution {
    public int minMoves(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int ele: nums) {
            sum += ele;
            max = Math.max(ele,  max);
        }
        return max * nums.length - sum;
    }
}
