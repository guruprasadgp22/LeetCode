class Solution {
    public int maxProduct(int[] nums) {
        int currentMax = nums[0];
        int result = 0;

        for(int i=1;i<nums.length;i++) {
            result = Math.max(result, (currentMax - 1) * (nums[i] - 1));
             if(currentMax < nums[i]) {
                currentMax = nums[i]; 
            }
        }

        return result;
    }
}
