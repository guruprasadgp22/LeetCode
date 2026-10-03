class Solution {
    public int longestPalindrome(String s) {
        int[] charCount = new int[60];
        for(char ch: s.toCharArray()) {
            charCount[ch - 'A']++;
        }

        int result = 0;
        int odd = 0;

        for(int n: charCount) {
            if(n % 2 == 1) {
                odd++;
            }

            result += n;
        }

        return odd == 0? result - odd : result - odd + 1;
    }
}
