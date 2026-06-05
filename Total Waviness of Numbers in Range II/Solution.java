class Solution {

    String s;
    long[][][][][] dpCnt;
    long[][][][][] dpWave;

    public long totalWaviness(long num1, long num2) {
        return solve(num2) - solve(num1 - 1);
    }

    private long solve(long n) {
        if (n < 0) return 0;

        s = String.valueOf(n);
        int len = s.length();

        dpCnt = new long[len][11][11][2][2];
        dpWave = new long[len][11][11][2][2];

        for (long[][][][] a : dpCnt)
            for (long[][][] b : a)
                for (long[][] c : b)
                    for (long[] d : c)
                        Arrays.fill(d, -1);

        for (long[][][][] a : dpWave)
            for (long[][][] b : a)
                for (long[][] c : b)
                    for (long[] d : c)
                        Arrays.fill(d, -1);

        return wave(0, 10, 10, 1, 0);
    }

    private long count(int pos, int prev2, int prev1,
                       int tight, int started) {

        if (pos == s.length()) {
            return 1;
        }

        if (dpCnt[pos][prev2][prev1][tight][started] != -1) {
            return dpCnt[pos][prev2][prev1][tight][started];
        }

        int limit = (tight == 1) ? s.charAt(pos) - '0' : 9;

        long ans = 0;

        for (int digit = 0; digit <= limit; digit++) {

            int ntight = (tight == 1 && digit == limit) ? 1 : 0;

            if (started == 0 && digit == 0) {
                ans += count(pos + 1, 10, 10, ntight, 0);
            } else if (started == 0) {
                ans += count(pos + 1, 10, digit, ntight, 1);
            } else {
                ans += count(pos + 1, prev1, digit, ntight, 1);
            }
        }

        return dpCnt[pos][prev2][prev1][tight][started] = ans;
    }

    private long wave(int pos, int prev2, int prev1,
                      int tight, int started) {

        if (pos == s.length()) {
            return 0;
        }

        if (dpWave[pos][prev2][prev1][tight][started] != -1) {
            return dpWave[pos][prev2][prev1][tight][started];
        }

        int limit = (tight == 1) ? s.charAt(pos) - '0' : 9;

        long ans = 0;

        for (int digit = 0; digit <= limit; digit++) {

            int ntight = (tight == 1 && digit == limit) ? 1 : 0;

            if (started == 0 && digit == 0) {

                ans += wave(pos + 1, 10, 10, ntight, 0);

            } else if (started == 0) {

                ans += wave(pos + 1, 10, digit, ntight, 1);

            } else {

                long ways =
                    count(pos + 1, prev1, digit, ntight, 1);

                long future =
                    wave(pos + 1, prev1, digit, ntight, 1);

                long cur = 0;

                if (prev2 != 10) {
                    if ((prev1 > prev2 && prev1 > digit) ||
                        (prev1 < prev2 && prev1 < digit)) {
                        cur = ways;
                    }
                }

                ans += future + cur;
            }
        }

        return dpWave[pos][prev2][prev1][tight][started] = ans;
    }
}
