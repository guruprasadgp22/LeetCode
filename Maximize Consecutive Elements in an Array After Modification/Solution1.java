class Solution {
    int n;
    int[][] dp;

    public int maxSelectedElements(int[] nums) {
        Arrays.sort(nums);
        n = nums.length;
        dp = new int[n+1][2];
        for(int[] x: dp) {
            Arrays.fill(x, -1);
        }
        int res = 1;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, Math.max(solve(i, 0, nums), solve(i, 1, nums)));
        }

        return res;
    }

    private int solve(int i, int incr, int[] nums) {
        if(dp[i][incr] != -1) {
            return dp[i][incr];
        }
        int len = 1;
        int currVal = nums[i] + incr;
        int j = lowerBound(i + 1, currVal + 1, nums);
        if (j != -1) {
            len = Math.max(len, 1 + solve(j, 0, nums));
        }

        j = lowerBound(i + 1, currVal, nums);

        if (j != -1) {
            len = Math.max(len, 1 + solve(j, 1, nums));
        }

        return dp[i][incr] = len;
    }

    private int lowerBound(int i, int key, int[] arr) {
        int j = n;

        while (i < j) {
            int mid = i + (j - i) / 2;
            if (arr[mid] < key) {
                i = mid + 1;
            } else {
                j = mid;
            }
        }

        return (i < n && arr[i] == key) ? i : -1;
    }
}
