class Solution {
    int[][] dp;
    public int maxPalindromes(String s, int k) {
        int n = s.length();
        
        if(k == 1) {
            return n;
        }
        dp = new int[n+1][n+1];
        for(int[] x: dp) {
            Arrays.fill(x, -1);
        }

        int i = 0;
        int j = k-1;

        return solve(s, k, i, j);
    }

    private int solve(String s, int k, int i, int j) {
        if(i >= s.length() || j >= s.length()) {
            return 0;
        }

        if(dp[i][j] != -1) {
            return dp[i][j];
        }

        if(isPalindrome(s, i, j)) {
            int take = 1 + solve(s, k, j+1, j+k);
            int grow = solve(s, k, i, j+1);
            int slide = solve(s, k, i+1, j+1);

            return dp[i][j] = Math.max(take, Math.max(grow, slide));
        }

        int grow = solve(s, k, i, j+1);
        int slide = solve(s, k, i+1, j+1);

        return dp[i][j] = Math.max(grow, slide);
    }

    private boolean isPalindrome(String s, int i, int j) {
        while(i < j) {
            if(s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
}
