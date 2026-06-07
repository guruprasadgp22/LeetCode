class Solution {
    public boolean consecutiveSetBits(int n) {
        int count = 0;
        while(n > 0) {
            if((n & 1) == 1 && ((n >> 1) & 1) == 1) {
                count++;
            }

            n >>= 1;
        }

        return count == 1;
    }
}
