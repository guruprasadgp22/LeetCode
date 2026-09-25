class Solution {
    List<List<String>> result;
    boolean[][] palindrome;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        List<String> curr = new ArrayList<>();

        int n = s.length();
        palindrome = new boolean[n+1][n+1];
        for(int len=1;len<=n;len++) {
            for(int i=0;i+len<=n;i++) {
                int j=i+len-1;
                if(i == j) {
                    palindrome[i][j] = true;
                } else if(i+1 == j) {
                    palindrome[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    palindrome[i][j] = (s.charAt(i) == s.charAt(j) && palindrome[i+1][j-1]);
                }
            }
        }

        solve(s, 0, curr);

        return result;
    }

    private void solve(String s, int idx, List<String> curr) {
        if(idx >= s.length()) {
            result.add(new ArrayList<>(curr));
            return;
        }

        for(int i=idx;i<s.length();i++) {
            if(palindrome[idx][i]) {
                curr.addLast(s.substring(idx, i+1));
                solve(s, i+1, curr);
                curr.removeLast();
            }
        }
    }
}
