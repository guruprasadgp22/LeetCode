class Solution {
    public int numTilings(int n) {
        if(n <= 2) {
            return n==2?2:1;
        }
        int MOD = 1_000_000_007;
        int zero = 1;
        int first = 1;
        int second = 2;

        for(int i=3;i<=n;i++) {
            int curr = ((second*2)%MOD +zero) % MOD;
            zero = first;
            first = second;
            second = curr;
        }

        return second;
    }
}
