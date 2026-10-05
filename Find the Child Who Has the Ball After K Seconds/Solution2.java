class Solution {
    public int numberOfChild(int n, int k) {
        int i = 0;
        int direction = 1;

        while(k > 0) {
            if(i == n-1) {
                direction = 0;
            } else if(i == 0) {
                direction = 1;
            }

            if(direction == 1) {
                i++;
            } else {
                i--;
            }
            k--;
        }

        return i;
    }
}
