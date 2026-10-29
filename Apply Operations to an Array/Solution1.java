class Solution {
    public int[] applyOperations(int[] nums) {
        int n = nums.length;
        for(int i=0;i<n-1;i++) {
            if(nums[i] == nums[i+1]) {
                nums[i] = 2*nums[i];
                nums[i+1] = 0;
            }
        }
        int i = 0;
        int[] res = new int[n];
        for(int ele: nums) {
            if(ele != 0) {
                res[i++] = ele;
            }
        }

        return res;
    }
}
