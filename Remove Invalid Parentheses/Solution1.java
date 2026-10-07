class Solution {
    List<String> result;
    int maxLen;
    public List<String> removeInvalidParentheses(String s) {
        maxLen = 0;
        result = new ArrayList<>();

        solve(0, 0, new StringBuilder(), s);

        return result;
    }

    private void solve(int i, int count, StringBuilder curr, String s) {
        if(count < 0) {
            return;
        }
        if(i == s.length()) {
            if(count == 0) {
                if(curr.length() > maxLen) {
                    maxLen = curr.length();
                    result.clear();
                }

                if(maxLen == curr.length() && !result.contains(curr.toString())) {
                    result.add(new StringBuilder(curr).toString());
                }
            }
            return;
        }

        if(s.charAt(i) != '(' && s.charAt(i) != ')') {
            curr.append(s.charAt(i));
            solve(i+1, count, curr, s);
            curr.deleteCharAt(curr.length()-1);
            return;
        }

        curr.append(s.charAt(i));
        solve(i+1, count + (s.charAt(i) =='('? 1 : -1), curr, s);
        curr.deleteCharAt(curr.length()-1);
        solve(i+1, count, curr, s);
    }
}
