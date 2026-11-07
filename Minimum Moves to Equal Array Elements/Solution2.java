class Solution {
    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for(int ele: nums) {
            min = Math.min(ele, min);
            sum += ele;
        }
        return sum - min*nums.length;
    }
}
