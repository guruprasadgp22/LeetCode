class Solution {
    int MOD = 1_000_000_007;
    int[] dp;
    public int numTilings(int n) {
        dp = new int[1001];
        Arrays.fill(dp, -1);
        return solve(n);
    }

    private int solve(int n) {
        if(n<=2) {
            return n==2?2:1;
        }

        if(dp[n] != -1) {
            return dp[n];
        }

        return dp[n] = ((2*solve(n-1))%MOD + solve(n-3))%MOD;
    }
}
