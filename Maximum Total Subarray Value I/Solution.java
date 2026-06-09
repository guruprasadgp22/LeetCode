class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int ele: nums) {
            min = Math.min(min, ele);
            max = Math.max(max, ele);
        }

        return (long) k * (max - min);
    }
}
