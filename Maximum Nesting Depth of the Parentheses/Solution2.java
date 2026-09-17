class Solution {
    public int maxDepth(String s) {
        Stack<Character> stack = new Stack<>();
        int max = 0;
        for(char ch: s.toCharArray()) {
            if(ch == '(') {
                stack.add('(');
            } else if(ch == ')') {
                max = Math.max(max, stack.size());
                stack.pop();
            }
        }

        return max;
    }
}
