class Solution {
    public String digitSum(String s, int k) {
        while(s.length() > k) {
            int n = s.length();
            String arr = "";
            for(int i=0;i<n;i+=k) {
                int sum = 0;
                for(int j=i;j<Math.min(i+k,n);j++) {
                    sum += s.charAt(j)-'0';
                }
                arr += sum;
            }
            s = new String(arr);
        }

        return s;
    }
}
