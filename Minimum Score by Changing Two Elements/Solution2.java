class Solution {
    public int minimizeSum(int[] nums) {
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        int min3 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        for(int ele: nums) {
            if(ele > max3) {
                max1 = max2;
                max2 = max3;
                max3 = ele;
            } else if(ele > max2) {
                max1 = max2;
                max2 = ele;
            } else if(ele > max1) {
                max1 = ele;
            }

            if(ele < min1) {
                min3 = min2;
                min2 = min1;
                min1 = ele;
            } else if(ele < min2) {
                min3 = min2;
                min2 = ele;
            } else if(ele < min3) {
                min3 = ele;
            }
        }

        return Math.min(max3 - min3, Math.min(max2 - min2, max1 - min1));
    }
}
