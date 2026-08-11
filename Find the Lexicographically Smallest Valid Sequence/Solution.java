class Solution {
    public int[] validSequence(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int j = n-1;
        int matchCount = 0;
        int[] matching = new int[m];
        for(int i=m-1;i>=0;i--) {
            if(j >= 0 && word1.charAt(i) == word2.charAt(j)) {
                matchCount++;
                j--;
            }
            matching[i] = matchCount;
        }

        j = 0;
        int i = 0;
        int[] ans = new int[n];
        boolean changePower = true;
        
        while(i < m && j < n) {
            if(word1.charAt(i) == word2.charAt(j)) {
                ans[j] = i;
                j++;
            } else if(changePower == true && i+1 < m && matching[i+1] >= n - j - 1) {
                ans[j] = i;
                j++;
                changePower = false;
            }
            i++;
        }

        if(j == n) {
            return ans;
        }

        return new int[]{};
    }
}
