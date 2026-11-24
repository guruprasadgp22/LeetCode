class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        int closest = 0;
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    closest = Math.abs(sum - target) < diff ? sum : closest;
                    diff = Math.min(diff, Math.abs(sum - target));
                }
            }
        }

        return closest;
    }
}
