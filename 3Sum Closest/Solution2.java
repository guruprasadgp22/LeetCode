class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int closest = 0;
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int j = i+1;
            int k = n-1;

            while(j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                closest = Math.abs(target - sum) < diff? sum: closest;
                diff = Math.min(diff, Math.abs(target - sum));

                if(sum < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }

        return closest;
    }
}
