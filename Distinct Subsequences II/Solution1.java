class Solution {
    int MOD = 1_000_000_007;
    int[] prevIndex;
    int[] dp;
    public int distinctSubseqII(String s) {
        int n = s.length();
        dp = new int[n+1];
        Arrays.fill(dp, -1);
        
        prevIndex = new int[n+1];

        int[] lastSeen = new int[26];

        for(int i=1;i<=n;i++) {
            int idx = s.charAt(i-1) - 'a';
            prevIndex[i] = lastSeen[idx];
            lastSeen[idx] = i;
        }

        int ans = (solve(n) -1) % MOD;

        return ans < 0? ans + MOD: ans;
    }

    private int solve(int n) {
        if(n == 0) {
            return 1;
        }

        if(dp[n] != -1) {
            return dp[n];
        }

        int total = (2 * solve(n-1)) % MOD;

        if(prevIndex[n] != 0) {
            int duplicate = solve(prevIndex[n] - 1);
            total = (total - duplicate + MOD) % MOD;
        }

        return dp[n] = total;
    }
}
