class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 0;

        for(char ch: s.toCharArray()) {
            if(ch == '(') {
                if(count > 0) {
                    sb.append(ch);
                }
                count++;
            } else {
                if(count > 1) {
                    sb.append(ch);
                }

                count--;
            }
        }

        return sb.toString();
    }
}
