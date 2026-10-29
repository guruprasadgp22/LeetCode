class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int ele : nums) {
            sum += ele;
        }

        if (sum % 2 == 1) {
            return false;
        }

        sum /= 2;
        boolean[] prev = new boolean[sum + 1];
        prev[0] = true;

        for (int i = n - 1; i >= 0; i--) {
            boolean[] curr = new boolean[sum + 1];
            for (int j = 0; j <= sum; j++) {
                boolean take = false;
                if (nums[i] <= j) {
                    take |= prev[j - nums[i]];
                }
                boolean skip = prev[j];
                curr[j] = skip | take;
            }
            prev = curr;
        }

        return prev[sum];
    }
}
