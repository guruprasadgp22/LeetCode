class Solution {
    int[][][] dp;
    int MOD = 1_000_000_007;
    public int numOfArrays(int n, int m, int k) {
        dp = new int[51][101][102];
        for(int i=0;i<51;i++) {
            for(int j=0;j<101;j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        int idx = 0;
        int searchCost = 0;
        int maxSoFor = -1;

        return solve(idx, searchCost, maxSoFor, n, m, k);
    }

    private int solve(int idx, int searchCost, int maxSoFor, int n, int m, int k) {
        if(idx >= n) {
            if(searchCost == k) {
                return 1;
            } else {
                return 0;
            }
        }

        int msf = maxSoFor + 1;
        if(dp[idx][searchCost][msf] != -1) {
            return dp[idx][searchCost][msf];
        }

        int result = 0;

        for(int i=1;i<=m;i++) {
            if(i > maxSoFor) {
                result = (result + solve(idx+1, searchCost + 1, i, n, m, k)) % MOD;
            } else {
                result = (result + solve(idx+1, searchCost, maxSoFor, n, m, k)) % MOD;
            }
        }

        return dp[idx][searchCost][msf] = result % MOD;
    }
}
