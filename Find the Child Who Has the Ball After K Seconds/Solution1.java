class Solution {
    public int numberOfChild(int n, int k) {
        int div = k / (n-1);
        int rem = k % (n-1);

        if(div % 2 == 0) {
            return rem;
        } else {
            return n - rem - 1;
        }
    }
}
