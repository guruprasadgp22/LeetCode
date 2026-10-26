class Solution {
    public int maxAscendingSum(int[] nums) {
        int n = nums.length;
        int curr = 0;
        int max = 0;

        for(int i=0;i<n;i++) {
            curr = nums[i];
            for(int j=i+1;j<n;j++) {
                if(nums[j] > nums[j-1]) {
                    curr+= nums[j];
                } else {
                    break;
                }
            }

            max = Math.max(curr, max);
        }

        return max;
    }
}
