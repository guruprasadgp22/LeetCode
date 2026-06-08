class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int[] ans = new int[n];
        int i = 0;
        int i2 = 0;
        int j = n - 1;
        int j2 = n - 1;

        while(i < n) {
            if(nums[i] < pivot) {
                ans[i2] = nums[i];
                i2++;
            }

            if(nums[j] > pivot) {
                ans[j2] = nums[j];
                j2--; 
            }

            i++;
            j--;
        }

        while(i2 <= j2) {
            ans[i2] = pivot;
            ans[j2] = pivot;
            i2++;
            j2--;
        }

        return ans;
    }
}
