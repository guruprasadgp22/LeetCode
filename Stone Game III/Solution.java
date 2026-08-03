class Solution {
    int dp[];
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;

        dp = new int[n+1];
        Arrays.fill(dp, -1);
        int ans = solve(0, stoneValue);
        if( ans == 0) {
            return "Tie";
        } else if(ans > 0) {
            return "Alice";
        } else {
             return "Bob";
        }
    }

    private int solve(int i, int[] arr) {
        if(i >= arr.length) {
            return  0;
        }
        int result = Integer.MIN_VALUE;
        if(dp[i] != -1) {
            return dp[i];
        }

        result = Math.max(result, arr[i] - solve(i+1, arr));
        if(i+1 < arr.length) {
            result = Math.max(result, arr[i] + arr[i+1] - solve(i+2, arr));
        }
        if(i+2 < arr.length) {
            result = Math.max(result, arr[i] + arr[i+1] + arr[i+2] - solve(i+3, arr));
        }
        return dp[i] = result;
    }
}
