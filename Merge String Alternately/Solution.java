class Solution {
    public String mergeAlternately(String word1, String word2) {
        int diff = word1.length() - word2.length();

        if(diff < 0) {
            diff = diff * -1;
        }

        int minSize = word1.length() < word2.length() ? word1.length() : word2.length();

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<minSize;i++) {
            sb.append(word1.charAt(i)).append(word2.charAt(i));
        }

        if(word1.length() > word2.length()) {
            int w1Len = word1.length();
            sb.append(word1.substring(w1Len-diff, w1Len));
        }

         if(word1.length() < word2.length()) {
            int w2Len = word2.length();
            sb.append(word2.substring(w2Len-diff, w2Len));
        }

        return sb.toString();
    }
}
