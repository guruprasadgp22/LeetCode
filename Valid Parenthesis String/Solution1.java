class Solution {
    int[][] dp;
    public boolean checkValidString(String s) {
        int n = s.length();
        dp = new int[n+1][n+1];
        for(int[] x: dp){
            Arrays.fill(x, -1);
        }
        return solve(0,0,s);   
    }

    private boolean solve(int open, int i, String s){
        if(i == s.length()) {
            return open == 0;
        }

        if(dp[i][open] != -1) {
            return dp[i][open] == 1;
        }

        boolean ans = false;
        if(s.charAt(i) == '(') {
            ans |= solve(open+1, i+1, s);;
        } else if(s.charAt(i) == ')') {
            if(open > 0) {
                ans |= solve(open-1, i+1, s);
            } else {
                ans |= false;
            }
        } else {
            boolean o1 = solve(open+1, i+1, s);
            boolean o2 = solve(open, i+1, s);

            boolean o3 = false;
            if(open > 0) {
                o3 = solve(open-1, i+1, s);
            }

            ans = o1 | o2 | o3;
        }

        dp[i][open] = ans? 1: 0;
        return ans;
    }
}
