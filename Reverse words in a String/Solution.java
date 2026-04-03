class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        String[] str = s.split("\\s+");

        String ans = new String();

        for(int i = str.length-1;i>=0;i--) {
            str[i] = str[i].trim();
            if(i==0) {
                ans += str[i];
                break;
            }
            ans += str[i] + " ";
        }

        return ans;
    }
}
