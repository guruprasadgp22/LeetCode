class Solution {
    public int minimumChanges(String s, int k) {
        int n = s.length();
        int[][] costDP = new int[n + 1][n + 1];
        for (int[] x : costDP) {
            Arrays.fill(x, Integer.MAX_VALUE);
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                costDP[i][j] = getCost(i, j, s);
            }
        }

        int[][] dp = new int[n + 1][k + 1];
        for (int[] x : dp) {
            Arrays.fill(x, Integer.MAX_VALUE);
        }
        dp[n][0] = 0;

        for (int i = n; i >= 0; i--) {
            for (int j = 1; j <= k; j++) {
                if (i + 2 * j > n) {
                    continue;
                }

                int minCost = Integer.MAX_VALUE;
                for (int x = i + 1; x < n; x++) {
                    int remainCost = dp[x + 1][j - 1];
                    if (remainCost == Integer.MAX_VALUE) {
                        continue;
                    }

                    minCost = Math.min(minCost, costDP[i][x] + remainCost);
                }
                dp[i][j] = minCost;
            }
        }

        return dp[0][k];
    }

    private int getCost(int i, int j, String s) {
        int len = j - i + 1;
        int minCost = Integer.MAX_VALUE;
        for (int d = 1; d < len; d++) {
            if (len % d != 0) {
                continue;
            }
            int cost = 0;
            for (int group = 0; group < d; group++) {
                int l = group + i;
                int r = l + (len / d - 1) * d;
                while (l < r) {
                    if (s.charAt(l) != s.charAt(r)) {
                        cost++;
                    }
                    l += d;
                    r -= d;
                }
            }

            minCost = Math.min(minCost, cost);
        }

        return minCost;
    }
}
