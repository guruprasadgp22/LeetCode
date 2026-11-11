class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;
        for (int ele : nums) {
            int digit = 0;
            while (ele > 0) {
                digit++;
                ele /= 10;
            }
            count += digit % 2 == 0 ? 1 : 0;
        }

        return count;
    }
}
