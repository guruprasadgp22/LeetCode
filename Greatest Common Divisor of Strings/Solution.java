class Solution {
    public String gcdOfStrings(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();

        int min = Math.min(len1, len2);

        for(int i = min; i>0;i--) {
            if(isDivisor(str1, str2, i)) {
                return str1.substring(0, i);
            }
        }

        return "";
    }

    public boolean isDivisor(String str1, String str2, int len) {
        if(str1.length() % len != 0 || str2.length() % len != 0) {
            return false;
        }

        int fact1 = str1.length() / len;
        int fact2 = str2.length() / len;

        return str1.substring(0, len).repeat(fact1).equals(str1) && str1.substring(0, len).repeat(fact2).equals(str2);
    }
}
