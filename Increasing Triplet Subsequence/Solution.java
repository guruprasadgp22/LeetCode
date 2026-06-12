class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for(int ele: nums) {
            if(ele <= first) {
                first = ele;
            } else if(ele <= second) {
                second = ele;
            } else {
                return true;
            }
        }

        return false;
    }
}
