class Solution {
    int[][][] dp;
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        dp = new int[2][n+1][n+1];
        for(int i=0;i<n+1;i++) {
            Arrays.fill(dp[0][i], -1);
            Arrays.fill(dp[1][i], -1);
        }
        return solve(1, 0, 1, piles);
    }

    private int solve(int person, int index, int m, int[] piles) {
        if(index >= piles.length) {
            return 0;
        }

        if(dp[person][index][m] != -1) {
            return dp[person][index][m];
        }

        int result = (person == 1? Integer.MIN_VALUE: Integer.MAX_VALUE);
        int stones = 0;

        for(int x = 1; x <= Math.min(piles.length-index, 2*m); x++) {
            stones += piles[index + x - 1];

            if(person == 1) {
                result = Math.max(result, stones + solve(0, index + x, Math.max(m, x), piles));
            } else {
                result = Math.min(result, solve(1, index + x, Math.max(m, x), piles));
            }
        }

        return dp[person][index][m] = result;
    }
}
