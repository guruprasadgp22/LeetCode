class Solution {
    int[][] dp;
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        dp = new int[n][2];
        for(int[] x: dp) {
            Arrays.fill(x, -1);
        }
        return solve(0, true, prices, fee);
    }

    private int solve(int i, boolean isBuy, int[] prices, int fee) {
        if(i >= prices.length) {
            return 0;
        }

        int j = isBuy? 1: 0;
        if(dp[i][j] != -1) {
            return dp[i][j];
        }

        int profit = 0;
        if(isBuy) {
            int buy = solve(i+1, false, prices, fee) - prices[i];
            int notBuy = solve(i+1, true, prices,fee);
            profit = Math.max(profit, Math.max(buy, notBuy));
        } else {
            int sell = prices[i] + solve(i+1, true, prices, fee) - fee;
            int notSell = solve(i+1, false, prices, fee);
            profit = Math.max(profit, Math.max(sell, notSell));
        }

        return dp[i][j] = profit;
    }
}
