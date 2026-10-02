class Solution {
    List<String> result;
    public List<String> generateParenthesis(int n) {
        result = new ArrayList<>();
        solve(new StringBuilder(), n);
        return result;
    }

    private void solve(StringBuilder curr, int n) {
        if(curr.length() == 2 * n) {
            if(isValid(curr.toString())) {
                result.add(curr.toString());
            }
            return;
        }

        curr.append("(");
        solve(curr, n);
        curr.deleteCharAt(curr.length()-1);

        curr.append(")");
        solve(curr, n);
        curr.deleteCharAt(curr.length() - 1);
    }

    private boolean isValid(String s) {
        int depth = 0;

        for(char ch: s.toCharArray()) {
            if(ch == '(') {
                depth++;
            } else {
                depth--;
                if(depth < 0){
                    return false;
                }
            }
        }

        return depth == 0;
    }
}
