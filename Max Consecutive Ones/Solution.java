class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int max = 0;

        for(int ele: nums) {
            if(ele == 1) {
                count++;
            } else {
                max = Math.max(count, max);
                count = 0;
            }
        }

        return Math.max(count, max);
    }
}
