class Solution {
    public int findMaxK(int[] nums) {
        int[] index = new int[2001];
        int maxEle = -1;
        for(int ele: nums) {
            if(ele < 0) {
                index[ele + 1000] = 1;
                if(index[-ele + 1000] == 1) {
                    maxEle = Math.max(-ele, maxEle);
                }
            } else {
                index[ele + 1000] = 1;
                if(index[-ele + 1000] == 1) {
                    maxEle = Math.max(ele, maxEle);
                }
            }
        }

        return maxEle;
    }
}
