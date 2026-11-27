class Solution {
    int[] copies;
    int cheapestPrice;
    int[][] dp;

    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        cheapestPrice = Integer.MAX_VALUE;
        copies = new int[n];
        for (int i = 0; i < n; i++) {
            cheapestPrice = Math.min(cheapestPrice, items[i][1]);
            int copy = 0;
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }

                if (items[j][0] % items[i][0] == 0) {
                    copy++;
                }
            }
            copies[i] = copy;
        }

        dp = new int[n+1][budget+1];
        for(int[] x: dp) {
            Arrays.fill(x, -1);
        }
        return solve(n, budget, items);
    }

    private int solve(int n, int budget, int[][] items) {
        if (n == 0) {
            return budget / cheapestPrice;
        }

        if(dp[n][budget] != -1) {
            return dp[n][budget];
        } 

        int skip = solve(n - 1, budget, items);
        int take = 0;
        if (items[n - 1][1] <= budget) {
            take = 1 + copies[n - 1] + solve(n - 1, budget - items[n - 1][1], items);
        }
        return dp[n][budget] = Math.max(take, skip);
    }
}
