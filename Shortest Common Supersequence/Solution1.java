class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();

        int[][] dp = new int[m+1][n+1];

        for(int i=m;i>=0;i--) {
            for(int j=n;j>=0;j--) {
                if(i == m) {
                    dp[i][j] = n - j;
                } else if(j == n) {
                    dp[i][j] = m - i;
                } else if(str1.charAt(i) == str2.charAt(j)) {
                    dp[i][j] = 1 + dp[i+1][j+1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i][j+1], dp[i+1][j]);
                }
            }
        }

        StringBuilder result = new StringBuilder();

        int i = 0;
        int j = 0;

        while(i < m &&  j < n) {
            if(str1.charAt(i) == str2.charAt(j)) {
                result.append(str1.charAt(i));
                i++;
                j++;
            } else {
                if(dp[i+1][j] < dp[i][j+1]) {
                    result.append(str1.charAt(i));
                    i++;
                } else {
                    result.append(str2.charAt(j));
                    j++;
                }
            }
        }

        while(i < m) {
            result.append(str1.charAt(i));
            i++;
        }

        while(j < n) {
            result.append(str2.charAt(j));
            j++;
        }

        return result.toString();
    }
}
