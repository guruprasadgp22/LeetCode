class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        char[] ar = s.toCharArray();
        char[] as = t.toCharArray();

        Arrays.sort(ar);
        Arrays.sort(as);
        String newStr1 = new String(ar);
        String newStr2 = new String(as);

        return newStr1.equals(newStr2);
    }
}
