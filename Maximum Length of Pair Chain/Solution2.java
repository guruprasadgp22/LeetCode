class Solution {
    public int findLongestChain(int[][] pairs) {
        int n = pairs.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp, 1);

        Arrays.sort(pairs, (a, b) -> {
            return Integer.compare(a[0], b[0]);
        });

        int result = 1;
        for(int i=1;i<n;i++) {
            for(int j=0;j<i;j++) {
                if(pairs[i][0] > pairs[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    result = Math.max(dp[i], result);
                }
            }
        }

        return result;
    }
}
