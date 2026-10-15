class Solution {
    int[][] dp;
    public int maxProfit(int[] prices) {
        int n = prices.length;
        dp = new int[n][2];
        for(int[] x: dp) {
            Arrays.fill(x, -1);
        }
        return solve(prices, 0, true);
    }

    private int solve(int[] prices, int day, boolean isBuy) {
        if(day >= prices.length) {
            return 0;
        }
        int j = isBuy? 1: 0;
        if(dp[day][j] != -1) {
            return dp[day][j];
        }

        int profit = 0;
        if(isBuy) {
            int buy = solve(prices, day+1, false) - prices[day];
            int notBuy = solve(prices, day+1, true);
            profit = Math.max(profit, Math.max(buy, notBuy));
        } else {
            int sell = solve(prices, day+2, true) + prices[day];
            int notSell = solve(prices, day+1, false);
            profit = Math.max(profit, Math.max(sell, notSell));
        }

        return dp[day][j] = profit;
    }
}
