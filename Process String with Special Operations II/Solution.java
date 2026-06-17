class Solution {
    public char processStr(String s, long k) {
                int n = s.length();
        long[] len = new long[n];
        long cur = 0;
        long LIMIT = (long) 4e18;

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (Character.isLowerCase(ch)) {
                cur++;
            } else if (ch == '*') {
                cur = Math.max(0, cur - 1);
            } else if (ch == '#') {
                cur = Math.min(LIMIT, cur * 2);
            } else if (ch == '%') {
                // length unchanged
            }

            len[i] = cur;
        }

        if (k >= cur) return '.';

        for (int i = n - 1; i >= 0; i--) {
            char ch = s.charAt(i);

            if (Character.isLowerCase(ch)) {
                if (len[i] - 1 == k) {
                    return ch;
                }
            } else if (ch == '#') {
                k %= (len[i] / 2);
            } else if (ch == '%') {
                k = len[i] - 1 - k;
            }
        }

        return '.';
    }
}
