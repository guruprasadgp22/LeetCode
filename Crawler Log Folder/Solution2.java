class Solution {
    public int minOperations(String[] logs) {
        Stack<String> stack = new Stack<>();
        for(String s: logs) {
            if(s.equals("../")) {
                if(!stack.isEmpty()) {
                    stack.pop();
                }
            } else if(s.equals("./")) {
                continue;
            } else {
                stack.add(s);
            }
        } 

        return stack.size();
    }
}
