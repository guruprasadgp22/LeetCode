class Solution {
    public boolean checkValidString(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n+1][n+2];
        
       dp[n][0] = true;

        for(int i=n-1;i>=0;i--) {
            for(int open = 0;open<=n;open++) {
                boolean ans = false;

                if(s.charAt(i) == '(') {
                    ans |= dp[i+1][open+1];
                } else if(s.charAt(i) == ')') {
                    if(open > 0) {
                        ans |= dp[i+1][open-1];
                    } else {
                        ans |= false;
                    }
                } else {
                    ans |= dp[i+1][open+1];
                    ans |= dp[i+1][open];

                    if(open > 0) {
                        ans |= dp[i+1][open-1];
                    }
                }

                dp[i][open] = ans;
            }
        }

        return dp[0][0];
    }
}
