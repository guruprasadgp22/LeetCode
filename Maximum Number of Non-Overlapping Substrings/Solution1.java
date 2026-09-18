class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int n = s.length();

        int[] startIndex = new int[26];
        Arrays.fill(startIndex, -1);
        int[] endIndex = new int[26];
        Arrays.fill(endIndex, 0);

        boolean[] isValid = new boolean[26];
        Arrays.fill(isValid, true);

        for(int i=0;i<n;i++) {
            int idx = s.charAt(i) - 'a';
            if(startIndex[idx] == -1) {
                startIndex[idx] = i;
            }
            endIndex[idx] = i;
        }

        for(int c=0;c<26;c++) {
            if(startIndex[c] == -1) {
                continue;
            }

            int start = startIndex[c];

            for(int i=start;i<=endIndex[c];i++) {
                if(startIndex[s.charAt(i) - 'a'] < start) {
                    isValid[c] = false;
                    break;
                }
                endIndex[c] = Math.max(endIndex[s.charAt(i) - 'a'], endIndex[c]);
            }
        }

        List<String> result = new ArrayList<>();
        int lasttakenIndex = Integer.MAX_VALUE;

        for(int i=n-1;i>=0;i--) {
            int c = s.charAt(i) - 'a';
            if(!isValid[c]) {
                continue;
            }

            if(i == startIndex[c] && endIndex[c] < lasttakenIndex) {
                result.add(s.substring(i, endIndex[c]+1));
                lasttakenIndex = i;
            }
        }

        return result;
    }
}
