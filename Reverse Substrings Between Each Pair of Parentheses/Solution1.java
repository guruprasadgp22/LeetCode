class Solution {
    public String reverseParentheses(String s) {
        Stack<StringBuilder> stack = new Stack<>();
        StringBuilder current = new StringBuilder();
        int i = 0;

        while(i < s.length()) {
            if(s.charAt(i) == '(') {
                stack.add(current);
                current = new StringBuilder();
            } else if(s.charAt(i) == ')'){
                current.reverse();
                current = stack.pop().append(current);
            } else {
                current.append(s.charAt(i));
            }
            i++;
        }

        return current.toString();
    }
}
