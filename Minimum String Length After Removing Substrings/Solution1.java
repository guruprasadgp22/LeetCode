class Solution {
    public int minLength(String s) {
        Stack<Character> stack = new Stack<>();
        for(char ch: s.toCharArray()) {
            if(ch == 'B') {
                if(!stack.isEmpty() && stack.peek() =='A') {
                    stack.pop();
                } else {
                    stack.add(ch);
                } 
            } else if(ch == 'D') {
                if(!stack.isEmpty() && stack.peek() == 'C') {
                    stack.pop();
                } else {
                    stack.add(ch);
                }
            } else {
                stack.add(ch);
            }
        }

        return stack.size();
    }
}
