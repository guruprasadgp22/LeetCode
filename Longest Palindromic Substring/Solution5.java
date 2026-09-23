class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();

        boolean[][] palindrome = new boolean[n+1][n+1];

        for(int len=1;len<=n;len++) {
            for(int i=0;i+len<=n;i++) {
                int j = i + len - 1;

                if(i==j) {
                    palindrome[i][j] = true;
                } else if(i+1 == j) {
                    palindrome[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    palindrome[i][j] = (s.charAt(i) == s.charAt(j) && palindrome[i+1][j-1]);
                }
            }
        }

        String ans = "";

        for(int i=0;i<n;i++) {
            for(int j=i;j<n;j++) {
                if(palindrome[i][j] && ans.length() < j - i +1) {
                    ans = s.substring(i, j+1);
                }
            }
        }

        return ans;
    }
}
