class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder sb = new StringBuilder();

        for(String str: words) {
            int count = 0;

            for(char ch:str.toCharArray()) {
                int index = ch - 'a';
                int weigh = weights[index];
                count += weigh;
            }
            count = count % 26;
            int idx = 26 - count - 1;
            sb.append((char)(idx + 'a'));
        }

        return sb.toString();
    }
}
