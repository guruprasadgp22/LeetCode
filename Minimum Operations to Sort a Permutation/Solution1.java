class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int count_asc = 0;
        int count_desc = 0;

        for (int i = 1; i < n; i++) {
            count_asc += (nums[i] == (nums[i - 1] + 1) % n) ? 1 : 0;
            count_desc += (nums[i - 1] == (nums[i] + 1) % n) ? 1 : 0;
        }

        if (count_asc == n - 1 && nums[0] == 0) {
            return 0;
        }

        if (count_asc == n - 1) {
            int left = n - nums[0];
            int right = 3 + nums[n - 1];
            return Math.min(left, right);
        }

        if (count_desc == n - 1) {
            int left = n - nums[n - 1] + 1;
            int right = (nums[0] + 1) % n + 1;
            return Math.min(left, right);
        }
        return -1;
    }
}
