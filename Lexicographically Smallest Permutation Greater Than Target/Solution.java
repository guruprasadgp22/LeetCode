class Solution {
    String result = "";
    public String lexGreaterPermutation(String s, String target) {
        int[] count = new int[26];
        for(char ch: s.toCharArray()) {
            count[ch - 'a']++;
        }

        int index = 0;
        boolean greater = false;
        StringBuilder curr = new StringBuilder();

        boolean ans = solve(count, index, target, curr, greater);

        return ans? result: "";
    }

    private boolean solve(int[] count, int index, String target, StringBuilder curr, boolean greater) {
        if(index == target.length()) {
            if(greater) {
                result = curr.toString();
                return true;
            }

            return false;
        }

        for(char ch='a'; ch <= 'z';ch++) {
            if(count[ch - 'a'] == 0) {
                continue;
            }

            if(greater == false && ch < target.charAt(index)) {
                continue;
            }

            curr.append(ch);
            count[ch - 'a']--;

            boolean isGreater = greater || (ch > target.charAt(index));

            if(solve(count, index+1, target, curr, isGreater)) {
                return true;
            }

            curr.deleteCharAt(index);
            count[ch - 'a']++;
        }

        return false;
    }
}
