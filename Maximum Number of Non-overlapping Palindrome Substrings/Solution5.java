class Solution {
    boolean[][] isPalindrome;
    int[] dp;
    public int maxPalindromes(String s, int k) {
        int n = s.length();
        isPalindrome = new boolean[n+1][n+1];
        palindrome(s);
        
        dp = new int[n+1];
        Arrays.fill(dp, -1);
        return solve(n, k);
    }

    private int solve(int len, int k) {
        if(len < k) {
            return 0;
        }

        if(dp[len] != -1) {
            return dp[len];
        }

        int j = len - 1;
        int result = solve(j, k);

        for(int i=0;j-i+1>=k;i++) {
            if(isPalindrome[i][j]) {
                result = Math.max(result, 1 + solve(i, k));
            }
        }

        return dp[len] = result;
    }

    private void palindrome(String s) {
        int n = s.length();

        for(int i=1;i<=n;i++) {
            for(int j=0;j+i<=n;j++) {
                int k = i+j-1;
                if(j == k) {
                    isPalindrome[j][k] = true;
                } else if(j+1 == k) {
                    isPalindrome[j][k] = s.charAt(j) == s.charAt(k);
                } else {
                    isPalindrome[j][k] = (s.charAt(j) == s.charAt(k) && isPalindrome[j+1][k-1]);
                }
            }
        }
    }
}
