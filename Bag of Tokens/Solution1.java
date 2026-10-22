class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int i = 0;
        int j = tokens.length-1;
        int count = 0;
        int ans = 0;
        if(tokens.length == 0 || tokens[0] > power) {
            return 0;
        }
        
        while(i <= j) {
            if(tokens[i] <= power){
                power -= tokens[i];
                i++;
                count++;
            } else {
                power += tokens[j];
                j--;
                count--;
            }

            ans = Math.max(ans, count);
        }

        return ans;
    }
}
