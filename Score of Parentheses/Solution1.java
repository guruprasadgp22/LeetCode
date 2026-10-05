class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int score = 0;

        for(int i=0;i<s.length();i++) {
            if(s.charAt(i) == '('){
                stack.add(score);
                score = 0;
            } else {
                if(s.charAt(i-1) == '(') {
                    score = stack.pop() + 1;
                } else  {
                    score = stack.pop() + score * 2;
                }
            }
        }

        return score;
    }
}
