class Solution {
    public int numTilings(int n) {
        if (n <= 2) {
            return n == 2 ? 2 : 1;
        }

        int MOD = 1_000_000_007;
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = ((dp[i - 1] * 2) % MOD + dp[i - 3]) % MOD;
        }

        return dp[n];
    }
}
