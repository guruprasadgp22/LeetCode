class Solution {
    public int maxLength(int[] nums) {
        int maxLen = 1;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int gcd = nums[i];
            int lcm = nums[i];
            int product = nums[i];
            for (int j = i + 1; j < n; j++) {
                gcd = GCD(gcd, nums[j]);
                lcm = LCM(lcm, nums[j]);
                product *= nums[j];

                if (product == lcm * gcd) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }

        return maxLen;
    }

    private int GCD(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }

        return a;
    }

    private int LCM(int a, int b) {
        return a / GCD(a, b) * b;
    }
}
