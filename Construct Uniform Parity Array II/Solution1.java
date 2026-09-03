class Solution {
    public boolean uniformArray(int[] nums1) {
        int oddMin = Integer.MAX_VALUE;
        int evenMin = Integer.MAX_VALUE;

        for(int ele: nums1) {
            if(ele % 2 == 0) {
                evenMin = Math.min(evenMin, ele);
            } else {
                oddMin = Math.min(oddMin, ele);
            }
        }

        if(evenMin == Integer.MAX_VALUE || oddMin == Integer.MAX_VALUE) {
            return true;
        }

        return oddMin < evenMin;
    }
}
