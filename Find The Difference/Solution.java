class Solution {
    public char findTheDifference(String s, String t) {
        char ch[] = s.toCharArray();
        Arrays.sort(ch);

        char str[] = t.toCharArray();
        Arrays.sort(str);

        for(int i = 0;i<str.length;i++) {
            if(i >= ch.length) {
                return str[i];
            }
            if(ch[i] == str[i]){
                continue;
            }

            return str[i];
        }

        return '1';
    }
}
