class Solution {
    boolean[][] isPalindrome;
    public int maxPalindromes(String s, int k) {
        int n = s.length();
        if(k == 1) {
            return n;
        }

        isPalindrome = new boolean[n+1][n+1];
        palindrome(s);
        
        int[][] dp = new int[n+1][n+1];
        for(int i=n-1;i>=0;i--) {
            for(int j=n-1;j>=0;j--) {
                if(isPalindrome[i][j]) {
                    int take = 1 + ((j+k <= n)? dp[j+1][j+k]: 0);
                    int grow = dp[i][j+1];
                    int slide = dp[i+1][j+1];

                    dp[i][j] = Math.max(take, Math.max(grow, slide));
                    continue;
                }

                int grow = dp[i][j+1];
                int slide = dp[i+1][j+1];

                dp[i][j] = Math.max(grow, slide);
            }
        }

        return dp[0][k-1];
    }

    private void palindrome(String s) {
        int n = s.length();
        for(int i=1;i<=n;i++) {
            for(int j=0;j+i<=n;j++){
                int k = i+j-1;
                if(j == k) {
                    isPalindrome[j][k] = true;
                } else if(j+1 == k) {
                    isPalindrome[j][k] = (s.charAt(j) == s.charAt(k));
                } else {
                    isPalindrome[j][k] = (s.charAt(j) == s.charAt(k) && isPalindrome[j+1][k-1]);
                }
            }
        }   
    }
}
