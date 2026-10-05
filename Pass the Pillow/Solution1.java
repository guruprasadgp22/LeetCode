class Solution {
    public int passThePillow(int n, int time) {
        int i = 1;
        int direction = 1;

        while(time > 0) {
            if(i == n) {
                direction = 0;
            } else if(i == 1) {
                direction = 1;
            }

            if(direction == 1) {
                i++;
            } else {
                i--;
            }

            time--;
        }

        return i;
    }
}
