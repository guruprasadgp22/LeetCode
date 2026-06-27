class Solution {
    private boolean isValid(String s) {
        if(s.matches("-?\\d+")){
            return true;
        }
        return false;
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for(String s: tokens) {
            if(isValid(s)) {
                int num = Integer.parseInt(s);
                stack.add(num);
            } else {
                char ch = s.charAt(0);
                int num2 = stack.pop();
                int num1 = stack.pop();

                if(ch == '+') {
                    int ans = num1 + num2;
                    stack.add(ans);
                } else if(ch == '-') {
                    int ans = num1 - num2;
                    stack.add(ans);
                } else if(ch == '*') {
                    int ans = num1 * num2;
                    stack.add(ans);
                } else if(ch == '/') {
                    int ans = num1/num2;
                    stack.add(ans);
                }
            }
        }    
        return stack.pop();
    }
}
