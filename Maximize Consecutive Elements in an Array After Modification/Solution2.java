class Solution {
    int n;
    public int maxSelectedElements(int[] nums) {
        n = nums.length;
        Arrays.sort(nums);
        int[][] dp = new int[n+1][2];
        int res = 1;
        for(int i=n-1;i>=0;i--) {
            for(int incr=0;incr<=1;incr++) {
                int len = 1;
                int currVal = nums[i] + incr;
                int j = lowerBound(i+1, currVal+1, nums);
                if(j != -1) {
                    len = Math.max(len, 1 + dp[j][0]);
                }

                j = lowerBound(i+1, currVal, nums);
                if(j != -1) {
                    len = Math.max(len, 1 + dp[j][1]);
                }
                dp[i][incr] = len;
                res = Math.max(res, dp[i][incr]);
            }
        }

        return res;
    }

    private int lowerBound(int i, int key, int[] arr) {
        int j = n;

        while(i < j) {
            int mid = i + (j - i)/2;

            if(arr[mid] < key) {
                i = mid + 1;
            } else {
                j = mid;
            }
        }

        return (i < n && arr[i] == key)? i: -1;
    }
}
