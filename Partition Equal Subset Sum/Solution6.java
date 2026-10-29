class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int ele: nums) {
            sum += ele;
        }

        if(sum % 2 == 1) {
            return false;
        } 
        sum /= 2;
        boolean[] prev = new boolean[sum+1];
        prev[0] = true;

        for(int i=1;i<=n;i++) {
            boolean[] curr = new boolean[sum+1];
            curr[0] = true;
            for(int j=0;j<=sum;j++){
                boolean take = false;
                if(nums[i-1] <= j) {
                    take |= prev[j-nums[i-1]];
                }
                boolean skip = prev[j];
                curr[j] = skip | take;
            }

            prev = curr;
        }

        return prev[sum];
    }
}
