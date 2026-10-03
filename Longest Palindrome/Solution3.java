class Solution {
    public int longestPalindrome(String s) {
        int[] charCount = new int[60];
        int oddCount = 0;
        for(char ch: s.toCharArray()) {
            charCount[ch-'A']++;
            if(charCount[ch-'A'] % 2 == 1){
                oddCount++;
            } else {
                oddCount--;
            }
        }

        return oddCount>0? s.length()-oddCount+1:s.length();
    }
}
