class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;
        for (int ele : nums) {
            if((10 <= ele && ele <= 99 ) || (1000 <= ele && ele <= 9999) || (ele == 100000)) {
                count++;
            }
        }
        return count;
    }
}
