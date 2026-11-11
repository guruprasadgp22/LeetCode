class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;
        for (int ele : nums) {
            count += Math.ceil(Math.log10(ele+1)) % 2 == 0? 1: 0;
        }
        return count;
    }
}
