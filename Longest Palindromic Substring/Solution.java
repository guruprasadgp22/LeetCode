class Solution {
    public String longestPalindrome(String s) {
        if(s == null || s.length() < 2) {
            return s;
        }   
        int start = 0;
        int maxLength = 1;

        for(int i=0;i<s.length();i++) {
            int len1 = center(s,i,i);
            int len2 = center(s,i,i+1);

            int len = Math.max(len1, len2);

            if(len > maxLength) {
                maxLength = len;
                start = i - (len-1)/2; 
            }
        }

        return s.substring(start, maxLength+start);
    }

    private int center(String s, int left, int right) {
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return right-left-1;
    }
}
