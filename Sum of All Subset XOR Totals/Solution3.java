class Solution {
    public int subsetXORSum(int[] nums) {
        int or = 0;
        for(int num: nums) {
            or |= num;
        }

        return or << nums.length-1;
    }
}
