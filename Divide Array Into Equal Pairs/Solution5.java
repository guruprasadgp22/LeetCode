class Solution {
    public boolean divideArray(int[] nums) {
        Arrays.sort(nums);
        for(int i=1;i<nums.length;i+=2) {
            int xor = nums[i] ^ nums[i-1];
            if(xor != 0) {
                return false;
            }
        }

        return true;
    }
}
