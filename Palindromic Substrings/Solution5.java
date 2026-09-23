class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int count = 0;

        for(int i=0;i<n;i++) {
            count += palindrome(i, i, s);
            count += palindrome(i, i+1, s);
        }
        return count;
    }

    private int palindrome(int i, int j, String s) {
        int count = 0;

        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
            count++;
        }

        return count;
    }
}
