class Solution {
    public char kthCharacter(int k) {
        String word = "a";

        while(word.length() < k) {
            String str = "";

            for(char ch: word.toCharArray()) {
                int index = ch - 'a';
                str += (char)((index + 1) % 26 + 'a');
            }
            word += str;
        }

        return word.charAt(k-1);
    }
}
