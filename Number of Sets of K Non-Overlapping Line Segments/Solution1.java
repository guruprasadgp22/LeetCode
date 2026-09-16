class Solution {
    int MOD = 1_000_000_007;
    int[][] dp;
    public int numberOfSets(int n, int k) {
        if(k == n-1) {
            return 1;
        }
        int i = 0;
        dp = new int[n+1][k+1];
        for(int[] x: dp) {
            Arrays.fill(x, -1);
        }

        return solve(i, k, n);
    }

    private int solve(int i, int k, int n) {
        if(k == 0) {
            return 1;
        }

        if(i >= n) {
            return 0;
        }

        if(dp[i][k] != -1) {
            return dp[i][k];
        }

        int skip = solve(i+1, k, n) % MOD;

        int take = 0;
        for(int j=i+1;j<n;j++) {
            take = (take + solve(j, k-1, n)) % MOD;
        }

        return dp[i][k] = (take + skip) % MOD;
    }
}
