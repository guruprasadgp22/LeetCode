class Solution {
    public int arraySign(int[] nums) {
        int negative = 0;
        int positive = 0;
        for(int ele: nums) {
            if(ele == 0) {
                return 0;
            } else if(ele < 0) {
                negative++;
            } else {
                positive++;
            }
        }
        if(negative % 2 == 0) {
            return 1;
        }
        return -1;
    }
}
