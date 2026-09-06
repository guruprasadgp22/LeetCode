class Solution {
    public String decodeString(String s) {
        int k = 0;
        StringBuilder curr = new StringBuilder();
        Stack<Integer> number = new Stack<>();
        Stack<StringBuilder> stack = new Stack<>();

        for(char ch: s.toCharArray()) {
            if(Character.isDigit(ch)) {
                k = k*10 + ch - '0';
            } else if(ch == '[') {
                number.add(k);
                stack.add(curr);
                curr = new StringBuilder();
                k = 0;
            } else if(ch == ']') {
                StringBuilder decode = stack.pop();
                int n = number.pop();
                for(int i=0;i<n;i++) {
                    decode.append(curr);
                }

                curr = decode;
            } else {
                curr.append(ch);
            }
        }

        return curr.toString();
    }
}
