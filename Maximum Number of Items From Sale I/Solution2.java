class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int cheapestPrice = Integer.MAX_VALUE;
        int[] copies = new int[n];
        for (int i = 0; i < n; i++) {
            int copy = 0;
            cheapestPrice = Math.min(cheapestPrice, items[i][1]);
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

        int[][] dp = new int[n + 1][budget + 1];
        for (int i = 0; i <= budget; i++) {
            dp[0][i] = i / cheapestPrice;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= budget; j++) {
                int skip = dp[i - 1][j];
                int take = 0;
                if (items[i - 1][1] <= j) {
                    take = 1 + copies[i - 1] + dp[i - 1][j - items[i - 1][1]];
                }
                dp[i][j] = Math.max(skip, take);
            }
        }

        return dp[n][budget];
    }
}
