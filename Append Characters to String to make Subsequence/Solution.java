class Solution {
    public int appendCharacters(String s, String t) {
        int i = 0;
        int j = 0;

        while(i < s.length() && j < t.length()) {
            char sch = s.charAt(i);
            char tch = t.charAt(j);

            if(sch == tch) {
                j++;
            }

            i++;
        }

        return t.length() - j;
    }
}
