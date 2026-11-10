class Solution {
    public int climbStairs(int n, int[] costs) {
        int[] dp = new int[n+1];
        for(int i=n;i>=0;i--) {
            int result = 0;
            if(i+1 <= n) {
                int j = i+1;
                result = costs[j-1] + (j-i)*(j-i) + dp[j];
            }
            if(i+2 <= n) {
                int j = i+2;
                result = Math.min(result, costs[j-1] + (j-i) * (j-i) + dp[j]);
            }

            if(i+3 <= n) {
                int j = i+3;
                result = Math.min(result, costs[j-1] + (j-i) * (j-i) + dp[j]);
            }

            dp[i] = result;
        }
        return dp[0];
    }
}
