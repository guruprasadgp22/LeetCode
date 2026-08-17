class Solution {
    int[][] dp;
    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;
        dp = new int[n+1][n+1];

        for(int i=0;i<n+1;i++) {
            Arrays.fill(dp[i], -1);
        }
        
        int[] prefixSum = new int[n];
        prefixSum[0] = stoneValue[0];

        for(int i=1;i<n;i++) {
            prefixSum[i] = prefixSum[i-1] + stoneValue[i];
        }

        return solve(0, n-1, prefixSum);
    }

    private int solve(int left, int right, int[] arr) {
        if(left >= right) {
            return 0;
        }

        if(dp[left][right] != -1) {
            return dp[left][right];
        }
        int score = 0;

        for(int mid = left; mid < right; mid++) {
            int leftSum = arr[mid] - (left - 1 >= 0? arr[left-1]: 0);
            int rightSum = arr[right] - arr[mid];

            if(leftSum < rightSum) {
                score = Math.max(score, leftSum + solve(left, mid, arr));
            } else if(leftSum > rightSum) {
                score = Math.max(score, rightSum + solve(mid + 1, right, arr));
            } else {
                score = Math.max(
                    score,
                    Math.max(
                        leftSum + solve(left, mid, arr),
                        rightSum + solve(mid+1, right, arr)
                    )
                );
            }
        }

        return dp[left][right] = score;
    }
}
