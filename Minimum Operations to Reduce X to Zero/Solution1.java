class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        int sum = 0;
        for(int ele: nums) {
            sum += ele;
        }

        int targetSum = sum - x;
        if(targetSum < 0) {
            return -1;
        } else  if(targetSum == 0) {
            return n;
        }

        int max = -1;
        sum = 0;
        int left = 0;

        for(int right=0;right<n;right++) {
            sum += nums[right];

            while(sum > targetSum) {
                sum -= nums[left];
                left++;
            }

            if(sum == targetSum) {
                max = Math.max(max, right - left + 1);
            }
        }
        
        return max == -1? max: n - max;
    }
}
