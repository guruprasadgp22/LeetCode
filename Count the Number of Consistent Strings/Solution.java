class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        boolean[] allowedSet = new boolean[26];
        int count = 0;

        for(char ch: allowed.toCharArray()) {
            allowedSet[ch - 'a'] = true;
        }

        for(String word: words) {
            boolean isAllowed = true;

            for(char ch: word.toCharArray()) {
                if(!allowedSet[ch - 'a']) {
                    isAllowed = false;
                    break;
                }
            }

            if(isAllowed) {
                count++;
            }
        }

        return count;
    }
}
