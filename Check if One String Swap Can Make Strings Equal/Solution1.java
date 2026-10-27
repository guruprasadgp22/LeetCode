class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int count = 0;
        int[] freq = new int[26];
        for(char ch: s1.toCharArray()) {
            freq[ch - 'a']++;
        }

        for(int i=0;i<s1.length();i++) {
            if(freq[s2.charAt(i) - 'a'] == 0) {
                return false;
            }

            if(s1.charAt(i) != s2.charAt(i)) {
                count++;
            }

            freq[s2.charAt(i)-'a']--;

            if(count > 2) {
                return false;
            }
        }

        return true;
    }
}
