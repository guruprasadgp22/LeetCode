class Solution {
    boolean dp[];
    public boolean winnerSquareGame(int n) {
        dp = new boolean[n+1];
        Arrays.fill(dp, false);

        if(n == 0) {
            return false;
        }

        for(int i=0;i<n+1;i++){
            for(int k=1;k*k <= i; k++) {
                if(!dp[i-k*k]) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n] == true;
    }
}
