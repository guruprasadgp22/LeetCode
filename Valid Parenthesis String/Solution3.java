class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> brackets = new Stack<>();
        Stack<Integer> star = new Stack<>();

        for(int i=0;i<s.length();i++) {
            if(s.charAt(i) == '*') {
                star.add(i);
            } else if(s.charAt(i) == '(') {
                brackets.add(i);
            } else {
                if(!brackets.isEmpty()) {
                    brackets.pop();
                } else if(!star.isEmpty()) {
                    star.pop();
                } else {
                    return false;
                }
            }
        }

        while(!brackets.isEmpty() && !star.isEmpty()) {
            if(brackets.peek() > star.peek()) {
                return false;
            }
            star.pop();
            brackets.pop();
        }

        return brackets.isEmpty();
    }
}
