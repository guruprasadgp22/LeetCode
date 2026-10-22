class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> result = new ArrayList<>();
        int n = words.length;

        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(i == j) {
                    continue;
                }

                if(KMPSearch(words[i], words[j])) {
                    result.add(words[i]);
                    break;
                }
            }
        }

        return result;
    }

    boolean KMPSearch(String pat, String txt) {
        int m = pat.length();
        int n = txt.length();
        int[] LPS = new int[m];
        lps(pat, LPS);

        int i = 0;
        int j = 0;

        while(i < n) {
            if(pat.charAt(j) == txt.charAt(i)) {
                i++;
                j++;
            }

            if(j == m) {
                return true;
            } else if(i <n && pat.charAt(j) != txt.charAt(i)) {
                if(j != 0) {
                    j = LPS[j-1];
                } else {
                    i++;
                }
            }
        }

        return false;
    }

    void lps(String pat, int[] LPS) {
        int m = pat.length();
        int i = 1;
        int len = 0;

        while(i < m) {
            if(pat.charAt(i) == pat.charAt(len)) {
                len++;
                LPS[i] = len;
                i++;
            } else {
                if(len != 0) {
                    len = LPS[len-1];
                } else {
                    i++;
                }
            }
        }
    }
}
