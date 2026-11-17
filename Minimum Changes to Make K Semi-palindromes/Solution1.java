class Solution {
    int n;
    int[][] dp;
    public int minimumChanges(String s, int k) {
        n = s.length();
        dp = new int[n+1][k+1];
        for(int[] x: dp) {
            Arrays.fill(x, -1);
        }
        return solve(s, 0, k);
    }

    private int solve(String s, int i, int k) {
        if(k == 0) {
            return i == n? 0: Integer.MAX_VALUE;
        }

        if(i + k * 2 > n) {
            return Integer.MAX_VALUE;
        }

        if(dp[i][k] != -1) {
            return dp[i][k];
        }

        int minCost = Integer.MAX_VALUE;
        for(int j=i+1;j<n;j++) {
            int remainCost = solve(s, j+1, k-1);
            if(remainCost == Integer.MAX_VALUE) {
                continue;
            }
            minCost = Math.min(minCost, getCost(i, j, s)+remainCost);
        }

        return dp[i][k] = minCost;
    }

    private int getCost(int i, int j, String s) {
        int len = j - i + 1;
        int minCost = Integer.MAX_VALUE;

        for(int d = 1;d<len;d++) {
            if(len % d != 0) {
                continue;
            }

            int cost = 0;
            for(int group = 0; group < d; group++) {
                int l = i + group;
                int r = l + (len/d - 1) * d;

                while(l < r) {
                    if(s.charAt(l) != s.charAt(r)) {
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
