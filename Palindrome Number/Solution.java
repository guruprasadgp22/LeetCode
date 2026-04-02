class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) {
            return false;
        }

        int y = x;
        int res = 0;
        while(x > 0) {
            int temp = x % 10;
            res = res * 10 + temp;
            x /= 10;
        }

        return res == y;
    }
}
