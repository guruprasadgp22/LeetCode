class Solution {
    boolean dp[];
    public boolean winnerSquareGame(int n) {
        dp = new boolean[n+1];
        Arrays.fill(dp, false);
        return solve(n);
    }

    private boolean solve(int n) {
        if(n == 0) {
            return false;
        }

        if(dp[n]) {
            return dp[n];
        }

        for(int k=1;k*k <= n; k++) {
            if(!solve(n-k*k)) {
                return dp[n] = true;
            }
        }

        return dp[n] = false;
    }
}
