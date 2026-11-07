class Solution {
    public int minMoves(int[] nums) {
        int max = Integer.MIN_VALUE;
        int op = 0;
        for(int ele: nums) {
            max = Math.max(ele,  max);
        }

        for(int ele: nums) {
            op += max - ele;
        }

        return op;
    }
}
