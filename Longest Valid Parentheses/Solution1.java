class Solution {
    public int longestValidParentheses(String s) {
        int open = 0;
        int close = 0;
        int result = 0;

        for(char ch: s.toCharArray()) {
            if(ch == '(') {
                open++;
            } else {
                close++;
            }

            if(open == close) {
                result = Math.max(2 * Math.min(close, open),  result);
            } else if(close > open) {
                close = open = 0;
            }
        }

        open = close = 0;
        for(int i=s.length()-1;i>=0;i--) {
            if(s.charAt(i) == ')') {
                close++;
            } else {
                open++;
            }

            if(open == close) {
                result = Math.max(open + close, result);
            } else if(close < open) {
                open = close = 0;
            }
        }

        return result;
    }
}
