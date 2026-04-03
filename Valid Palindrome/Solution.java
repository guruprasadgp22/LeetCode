class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        String str = s.replaceAll("[^a-zA-Z0-9]", "");

        String ans = "";

        for(int i=str.length()-1;i>=0;i--) {
            ans += str.charAt(i);
        }

        return ans.equals(str);
    }
}
