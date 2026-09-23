class Solution {
    public String longestPalindrome(String s) {
        String ans = "";
        int n = s.length();

        for(int i=0;i<n;i++) {
            for(int j=i;j<n;j++) {
                if(solve(i, j, s) && ans.length() < j - i + 1) {
                    ans = s.substring(i, j+1);
                }
            }
        }

        return ans;
    }

    private boolean solve(int i, int j, String s) {
        if(i > j) {
            return true;
        }

        if(s.charAt(i) == s.charAt(j)) {
            return solve(i+1, j-1, s);
        }

        return false;
    }
}
