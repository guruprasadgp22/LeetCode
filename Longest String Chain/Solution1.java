class Solution {
    int[][] dp;
    public int longestStrChain(String[] words) {
        int n = words.length;
        dp = new int[n+1][n+1];
        for(int[] x: dp) {
            Arrays.fill(x, -1);
        }

        Arrays.sort(words, (a, b) -> {
            if(a.length() == b.length()) {
                return a.compareTo(b);
            }

            return a.length() - b.length();
        });

        return solve(0, -1, words);
    }

    private int solve(int i, int prevIdx, String words[]) {
        if(i >= words.length) {
            return 0;
        }

        int prev = prevIdx + 1;
        if(dp[i][prev] != -1) {
            return dp[i][prev];
        }

        int skip = solve(i+1, prevIdx, words);

        int take = 0;
        if(prevIdx == -1 || (words[i].length() - words[prevIdx].length() == 1 && isPredecessor(words[i], words[prevIdx]))) {
            take = 1 + solve(i+1, i, words);
        }

        return dp[i][prev] = Math.max(skip, take);
    }

    private boolean isPredecessor(String a, String b) {
        int i = 0;
        int j = 0;
        int m = a.length();
        int n = b.length();

        while(i < m && j < n) {
            if(a.charAt(i) == b.charAt(j)) {
                j++;
            }

            i++;
        }

        return j == n;
    }
}
