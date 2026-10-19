class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] res = new int[n];
        if (k == 0) {
            return res;
        }

        int i = -1;
        int j = -1;
        if (k < 0) {
            i = n + k;
            j = n - 1;
        } else {
            i = 1;
            j = k;
        }

        int sum = 0;
        for (int m = i; m <= j; m++) {
            sum += code[m];
        }

        for (int m = 0; m < n; m++) {
            res[m] = sum;
            sum -= code[i % n];
            i++;
            j++;
            sum += code[j % n];
        }

        return res;
    }
}
