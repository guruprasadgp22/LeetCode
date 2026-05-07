class Solution {
    public List<String> commonChars(String[] words) {
        List<String> ans = new ArrayList<>();

        int[] common = new int[26];  
        Arrays.fill(common, Integer.MAX_VALUE);

        for(String word: words) {
            int[] freq = new int[26];

            for(char ch: word.toCharArray()) {
                freq[ch-'a']++;
            }

            for(int i=0;i<26;i++) {
                common[i] = Math.min(common[i], freq[i]);
            }
        }

        for(int i=0;i<26;i++) {
            while(common[i] > 0) {
                ans.add(String.valueOf((char)(i+'a')));
                common[i]--;
            }
        }
        
        return ans;
    }
}
