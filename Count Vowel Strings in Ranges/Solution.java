class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int[] prefixSum = new int[n+1];

        for(int i=0;i<words.length;i++) {
                String word = words[i];

                if(isVowel(word.charAt(0)) && isVowel(word.charAt(word.length()-1))) {
                    prefixSum[i+1] = prefixSum[i]+1;
                } else{
                    prefixSum[i+1] = prefixSum[i];
                }
        }

        int[] ans = new int[queries.length];

        for(int i=0;i<queries.length;i++) {
            int start = queries[i][0];
            int end = queries[i][1];

            ans[i] = prefixSum[end+1] - prefixSum[start];
        }

        return ans;
    }

    public boolean isVowel(char ch) {
        ch = Character.toLowerCase(ch);

        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}
