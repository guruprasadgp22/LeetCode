class Solution {
    List<String> result;
    public List<String> generateParenthesis(int n) {
        result = new ArrayList<>();
        solve(0, 0, new StringBuilder(), n);
        return result;
    }

    private void solve(int open, int close, StringBuilder sb, int n) {
        if(sb.length() == 2 * n) {
            result.add(sb.toString());
            return;
        }
        if(open < n){
            sb.append("(");
            solve(open+1, close, sb, n);
            sb.deleteCharAt(sb.length()-1);
        }

        if(close < open) {
            sb.append(")");
            solve(open, close+1, sb, n);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
