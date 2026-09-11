class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n <= 0) {
            return false;
        }

        if(n == 1) {
            return true;
        }

        int rem = 0;

        while(n > 0) {
            rem = n % 2;

            if(n > 2 && rem != 0) {
                return false;
            }

            n /= 2;
        }

        return true;
    }
}
