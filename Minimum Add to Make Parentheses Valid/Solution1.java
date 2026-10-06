class Solution {
    public int minAddToMakeValid(String s) {
        int depth = 0;
        Stack<Character> stack = new Stack<>();

        for(char ch: s.toCharArray()){
            if(ch == '('){
                stack.add('(');
            } else {
                if(!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    stack.add(')');
                }
                depth--;
            }
        }

        return stack.size();
    }
}
