class Solution {
    public String maximumOddBinaryNumber(String s) {
        int one = 0;
        for(char ch: s.toCharArray()) {
            if(ch == '1') {
                one++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<one-1;i++) {
            sb.append(1);
        }

        for(int i=0;i<s.length() - one;i++) {
            sb.append(0);
        }

        return sb.append(1).toString();
    }
}
