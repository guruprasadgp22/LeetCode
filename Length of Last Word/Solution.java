class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim().replaceAll("\\s+", " ");
        String str[] = s.split("\\s+");
        return str[str.length-1].length();
    }
}
