class Solution {
    String result;
    int halfLen;
    char midChar = ' ';
    public String lexPalindromicPermutation(String s, String target) {
        int n = s.length();
        int[] count = new int[26];
        for(char ch: s.toCharArray()) {
            count[ch - 'a']++;
        }

        int oddCount = 0;
        for(int i=0;i<26;i++) {
            if(count[i] % 2 == 1) {
                oddCount++;
                midChar = (char)(i + 'a');
            }
        }

        if(oddCount > 1) {
            return "";
        }

        for(int i=0;i<26;i++) {
            count[i] /= 2;
        }

        halfLen = n/2;

        StringBuilder curr = new StringBuilder();
        int index = 0;
        boolean greater = false;

        boolean ans = solve(curr, count, index, target, greater);

        return ans? result: "";
    }

    private boolean solve(StringBuilder curr, int[] count, int index, String target, boolean greater) {
        if(index == halfLen) {
            String candidate = new StringBuilder(curr).toString();
            String rightHalf = new StringBuilder(curr).reverse().toString();

            if(midChar == ' ') {
                candidate += rightHalf;
            } else {
                candidate += midChar + rightHalf;
            }

            if(candidate.compareTo(target) > 0) {
                result = candidate;
                return true;
            }

            return false;
        }

        for(char ch='a';ch<='z';ch++) {
            if(count[ch - 'a'] == 0) {
                continue;
            }

            if(greater == false && ch < target.charAt(index)) {
                continue;
            }

            curr.append(ch);
            count[ch - 'a']--;

            boolean isGreater = greater || (ch > target.charAt(index));

            if(solve(curr, count, index+1, target, isGreater)) {
                return true;
            }

            curr.deleteCharAt(index);
            count[ch - 'a']++;
        }

        return false;
    }
}
