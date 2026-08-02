class Solution {
    int[][] dp;
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        dp = new int[n+1][n+1];
        for(int i=0;i<n+1;i++) {
            Arrays.fill(dp[i], -1);
        }

        return solve(piles, 0, piles.length-1) >0;
    }

    public int solve(int[] arr, int start, int end) {
        if(start > end) {
            return 0;
        }

        if(dp[start][end] != -1) {
            return dp[start][end];
        }

        int sum_s = arr[start] - solve(arr, start+1, end);
        int sum_e = arr[end] - solve(arr, start, end-1);

        return dp[start][end] = Math.max(sum_s, sum_e);
    }
}
