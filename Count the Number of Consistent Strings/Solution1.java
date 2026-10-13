class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int mask = 0;
        for(char ch: allowed.toCharArray()) {
            int idx = ch - 'a';
            mask |= (1 << idx);
        }

        int result = 0;
        for(String s: words) {
            boolean found = true;
            for(char ch: s.toCharArray()) {
                int idx = ch - 'a';
                if(((mask >> idx) & 1) != 1) {
                    found = false;
                    break;
                }
            }

            if(found) {
                result++;
            }
        }

        return result;
    }
}
