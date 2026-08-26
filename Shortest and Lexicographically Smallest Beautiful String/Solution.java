class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();
        String result = "";

        for(int len = k; len <= n; len++) {
            for(int i=0; i <= n - len; i++) {
                String temp = s.substring(i, i+len);

                int count = 0;

                for(char ch: temp.toCharArray()) {
                    if(ch == '1') {
                        count++;
                    }
                }

                if(count == k) {
                    if(result == "" || temp.compareTo(result) < 0) {
                        result = temp;
                    }
                }
            }

            if(result != "") {
                return result;
            }
        }

        return result;
    }
}
