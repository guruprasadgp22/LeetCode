class Solution {
    int MOD = 1_000_000_007;
    public int distinctSubseqII(String s) {
        int n = s.length();

        int[] dp = new int[n+1];

        int prev[] = new int[n+1];

        int[] lastSeen = new int[26];
        Arrays.fill(lastSeen, -1);

        for(int i=1;i<=n;i++) {
            int idx = s.charAt(i - 1) - 'a';
            prev[i] = lastSeen[idx];
            lastSeen[idx] = i;
        }

        dp[0] = 1;

        for(int i=1;i<=n;i++) {
            int total = (2 * dp[i-1]) % MOD;

            if(prev[i] != -1) {
                int duplicate = dp[prev[i] - 1] % MOD;
                total = (total - duplicate + MOD) % MOD;
            }

            dp[i] = total;
        }

        return (dp[n]-1 + MOD) % MOD;
    }
}
