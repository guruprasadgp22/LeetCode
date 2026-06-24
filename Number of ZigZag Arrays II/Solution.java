class Solution {
    static final long MOD = 1_000_000_007L;

    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;
        int sz = 2 * m;

        // State vector for length = 2
        long[] base = new long[sz];

        // up[v] = number of smaller values
        for (int v = 0; v < m; v++) {
            base[v] = v;                 // last move was upward
            base[m + v] = m - 1 - v;     // last move was downward
        }

        // Build transition matrix
        long[][] T = new long[sz][sz];

        // newUp[v] = sum down[u] for u < v
        for (int v = 0; v < m; v++) {
            for (int u = 0; u < v; u++) {
                T[v][m + u] = 1;
            }
        }

        // newDown[v] = sum up[u] for u > v
        for (int v = 0; v < m; v++) {
            for (int u = v + 1; u < m; u++) {
                T[m + v][u] = 1;
            }
        }

        // Need length n. Base corresponds to length 2.
        long[][] P = matrixPower(T, n - 2);

        long[] result = multiply(P, base);

        long ans = 0;
        for (long x : result) {
            ans = (ans + x) % MOD;
        }

        return (int) ans;
    }

    private long[][] matrixPower(long[][] A, int exp) {
        int n = A.length;
        long[][] res = new long[n][n];

        for (int i = 0; i < n; i++) {
            res[i][i] = 1;
        }

        while (exp > 0) {
            if ((exp & 1) == 1) {
                res = multiply(res, A);
            }
            A = multiply(A, A);
            exp >>= 1;
        }

        return res;
    }

    private long[][] multiply(long[][] A, long[][] B) {
        int n = A.length;
        long[][] C = new long[n][n];

        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {
                if (A[i][k] == 0) continue;
                long val = A[i][k];

                for (int j = 0; j < n; j++) {
                    if (B[k][j] == 0) continue;
                    C[i][j] = (C[i][j] + val * B[k][j]) % MOD;
                }
            }
        }

        return C;
    }

    private long[] multiply(long[][] A, long[] v) {
        int n = A.length;
        long[] res = new long[n];

        for (int i = 0; i < n; i++) {
            long sum = 0;
            for (int j = 0; j < n; j++) {
                if (A[i][j] != 0) {
                    sum = (sum + A[i][j] * v[j]) % MOD;
                }
            }
            res[i] = sum;
        }

        return res;
    }
}
