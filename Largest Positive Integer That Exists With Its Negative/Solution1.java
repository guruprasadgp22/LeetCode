class Solution {
    public int findMaxK(int[] nums) {
        int maxEle = -1;

        for(int i=0;i<nums.length;i++) {
            for(int j=i;j<nums.length;j++) {
                if(nums[i] == -nums[j] && maxEle < Math.max(nums[i], nums[j])) {
                    maxEle = Math.max(nums[i], nums[j]);
                }
            }
        }

        return maxEle;
    }
}
