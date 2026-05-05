class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int[] alp = new int[26];

        for(int i=0;i<26;i++){
            alp[i] = -1;
        }

        int max = -1;

        for(int i=0;i<s.length();i++) {
            char ch = s.charAt(i);

            if(alp[ch - 'a'] == -1) {
                alp[ch - 'a'] = i;
            } else {
                max = Math.max(max, i - alp[ch - 'a'] - 1);
            }
        }

        return max;
    }
}
