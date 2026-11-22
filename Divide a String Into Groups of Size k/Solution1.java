class Solution {
    public String[] divideString(String s, int k, char fill) {
        int n = s.length();
        String[] res = new String[n % k == 0 ? n / k : n / k + 1];
        String arr = "";
        int idx = 0;

        for (char ch : s.toCharArray()) {
            arr += ch;
            if (arr.length() == k) {
                res[idx++] = arr;
                arr = "";
            }
        }

        if(arr.length() > 0){
            for(int i=arr.length();i<k;i++) {
                arr += fill;
            }

            res[idx++] = arr;
        }

        return res;
     }
}
