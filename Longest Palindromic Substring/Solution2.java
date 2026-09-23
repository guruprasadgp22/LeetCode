class Solution {
    public String longestPalindrome(String s) {
        String ans = "";
        int n = s.length();
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++) {
                if(isPalindrome(i, j, s) && ans.length() < j-i+1) {
                    ans = s.substring(i, j+1);
                }
            }
        }

        return ans;
    }

    private boolean isPalindrome(int i, int j, String s) {
        while(i <= j) {
            if(s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }

        return true;
    }
}
