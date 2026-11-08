class Solution {
    public boolean divideArray(int[] nums) {
        Arrays.sort(nums);
        for(int i=1;i<nums.length;i+=2) {
            if(nums[i] != nums[i-1]) {
                return false;
            }
        }

        return true;
    }
}
