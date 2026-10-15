class Solution {
    public String makeFancyString(String s) {
        StringBuilder res = new StringBuilder();
        int n = s.length();
        res.append(s.charAt(0));
        int freq = 1;
        for(int i=1;i<n;i++) {
            if(res.charAt(res.length() - 1) == s.charAt(i)) {
                freq++;
                if(freq < 3) {
                    res.append(s.charAt(i));
                }
            } else {
                res.append(s.charAt(i));
                freq = 1;
            }
        }

        return res.toString();
    }
}
