class Solution {
    public boolean isMonotonic(int[] nums) {
        return isIncre(nums) || isDecre(nums);
    }

    public boolean isIncre(int nums[]) {
        int n = nums.length;

        for(int i=0;i<n-1;i++) {
            if(nums[i] <= nums[i+1]) {
                continue;
            }

            return false;
        }

        return true;
    }

    public boolean isDecre(int nums[]) {
        int n = nums.length;

        for(int i=0;i<n-1;i++) {
            if(nums[i] >= nums[i+1]) {
                continue;
            }

            return false;
        }

        return true;
    }
}
