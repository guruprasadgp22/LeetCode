class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] res = new int[n];
        if(k == 0) {
            for(int i=0;i<n;i++) {
                res[i] = 0;
            }
        } else if(k > 0) {
            for(int i=0;i<n;i++) {
                int sum = 0;
                for(int j=i+1;j<=i+k;j++) {
                    sum += code[j%n];
                }
                res[i] = sum;
            }
        } else {
            for(int i=0;i<n;i++) {
                int sum = 0;
                for(int j=i-1;j>=i+k;j--) {
                    sum += code[(j+n)%n];
                }
                res[i] = sum;
            }
        }

        return res;
    }
}
