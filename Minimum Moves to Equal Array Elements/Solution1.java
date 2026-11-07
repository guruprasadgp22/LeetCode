class Solution {
    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        for(int ele: nums) {
            min = Math.min(ele, min);
        }

        int op = 0;
        for(int ele: nums) {
            op += ele - min;
        }

        return op;
    }
}
