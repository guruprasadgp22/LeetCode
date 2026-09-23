class Solution {
    int[][] dp;
    public int countSubstrings(String s) {
        int count = 0;
        int n = s.length();

        dp = new int[n+1][n+1];
        for(int[] x: dp) {
            Arrays.fill(x, -1);
        }

        for(int i=0;i<n;i++) {
            for(int j=i;j<n;j++) {
                if(dp[i][j] == 1 || (dp[i][j] == -1 && isPalindrome(i, j, s))) {
                    count++;
                }
            }
        }

        return count;
    }

    private boolean isPalindrome(int start, int end, String s) {
        if(start > end) {
            return true;
        }

        if(dp[start][end] != -1) {
            return dp[start][end] == 1? true: false;
        }

        if(s.charAt(start) == s.charAt(end)) {
            dp[start][end] = isPalindrome(start+1, end-1, s) ? 1: 0;
            return dp[start][end] == 1? true: false;
        }

        dp[start][end] = 0;
        return false;
    }
}
