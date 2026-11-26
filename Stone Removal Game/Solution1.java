class Solution {
    public boolean canAliceWin(int n) {
        if(n < 10) {
            return false;
        }

        int i = 10;

        while(n > 0) {
            n -= i;
            i--;

            if(n < i) {
                return i % 2 == 1? true: false;
            }
        }

        return true;
    }
}
