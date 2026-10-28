class Solution {
    public String clearDigits(String s) {
        Stack<Character> stack = new Stack<>();
        for(char ch: s.toCharArray()) {
            if(Character.isDigit(ch)) {
                stack.pop();
            } else {
                stack.add(ch);
            }
        }

        StringBuilder res = new StringBuilder();
        while(!stack.isEmpty()) {
            res.append(stack.pop());
        }

        return res.reverse().toString();
    }
}
