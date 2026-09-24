class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();

        int[][] palindrome = new int[n+1][n+1];
        for(int i=0;i<n;i++) {
            palindrome[i][i] = 1;
        }

        for(int len=2;len <= n; len++) {
            for(int i=0;i+len <= n; i++) {
                int j = i + len - 1;
                
                if(s.charAt(i) == s.charAt(j)) {
                    palindrome[i][j] = 2 + palindrome[i+1][j-1];
                } else {
                    palindrome[i][j] = Math.max(palindrome[i+1][j], palindrome[i][j-1]);
                }
            }
        }

        return palindrome[0][n-1];
    }
}
