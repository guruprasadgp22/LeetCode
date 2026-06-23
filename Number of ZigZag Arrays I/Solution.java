class Solution {
    static final int MOD = 1_000_000_007;

    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;

        long[] up = new long[m];
        long[] down = new long[m];

        // Length = 2
        for (int v = 0; v < m; v++) {
            up[v] = v;              // previous value < v
            down[v] = m - 1 - v;    // previous value > v
        }

        if (n == 2) {
            long ans = 0;
            for (int i = 0; i < m; i++) {
                ans = (ans + up[i] + down[i]) % MOD;
            }
            return (int) ans;
        }

        for (int len = 3; len <= n; len++) {
            long[] prefixDown = new long[m];
            long[] prefixUp = new long[m];

            prefixDown[0] = down[0];
            prefixUp[0] = up[0];

            for (int i = 1; i < m; i++) {
                prefixDown[i] = (prefixDown[i - 1] + down[i]) % MOD;
                prefixUp[i] = (prefixUp[i - 1] + up[i]) % MOD;
            }

            long[] newUp = new long[m];
            long[] newDown = new long[m];

            for (int v = 0; v < m; v++) {
                // previous value < v and previous sign was down
                if (v > 0)
                    newUp[v] = prefixDown[v - 1];

                // previous value > v and previous sign was up
                long totalUp = prefixUp[m - 1];
                long uptoV = prefixUp[v];
                newDown[v] = (totalUp - uptoV + MOD) % MOD;
            }

            up = newUp;
            down = newDown;
        }

        long ans = 0;
        for (int i = 0; i < m; i++) {
            ans = (ans + up[i] + down[i]) % MOD;
        }

        return (int) ans;
    }
}
