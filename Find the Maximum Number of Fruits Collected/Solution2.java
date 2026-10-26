class Solution {
    public int maxCollectedFruits(int[][] fruits) {
        int n = fruits.length;
        int c1 = 0;
        for (int i = 0; i < n; i++) {
            c1 += fruits[i][i];
            fruits[i][i] = 0;
        }

        int[][] dp1 = new int[n][n];
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                int max = Math.max(dp1[i + 1][j - 1], dp1[i + 1][j]);
                if (j + 1 < n) {
                    max = Math.max(max, dp1[i + 1][j + 1]);
                }

                dp1[i][j] = max + fruits[i][j];
            }
        }

        int[][] dp2 = new int[n][n];
        for (int j = n-2; j >= 0;j--) {
            for (int i = j + 1; i<n ; i++) {
                int max = Math.max(dp2[i - 1][j + 1], dp2[i][j + 1]);
                if (i + 1 < n) {
                    max = Math.max(max, dp2[i + 1][j + 1]);
                }

                dp2[i][j] = max + fruits[i][j];
            }
        }

        return c1 + dp1[0][n - 1] + dp2[n - 1][0];
    }
}
