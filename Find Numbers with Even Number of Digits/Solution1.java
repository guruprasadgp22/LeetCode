class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;
        for(int ele: nums) {
            String num = String.valueOf(ele);
            count += num.length() % 2 == 0? 1: 0;
        }

        return count;
    }
}
