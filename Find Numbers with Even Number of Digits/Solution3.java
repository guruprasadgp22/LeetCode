class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;
        for (int ele : nums) {
            int digit = (int)(Math.floor(Math.log10(ele))) + 1;
            count += digit % 2== 0? 1:0;
        }

        return count;
    }
}
