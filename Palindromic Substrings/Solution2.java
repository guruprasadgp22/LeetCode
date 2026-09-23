class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        int n = s.length();

        for(int i=0;i<n;i++) {
            for(int j=i;j<n;j++) {
                if(isPalindrome(i, j, s)) {
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

        if(s.charAt(start) == s.charAt(end)) {
            return isPalindrome(start+1, end-1, s);
        }

        return false;
    }
}
