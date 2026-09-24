class Solution {
    public int tribonacci(int n) {
        if(n == 0) {
            return  0;
        } else if(n == 1 || n == 2) {
            return 1;
        }

        int first = 0;
        int sec = 1;
        int third = 1;
        int result = 1;

        for(int i=3;i<=n;i++) {
            result = first + sec + third;
            first = sec;
            sec = third;
            third = result;
        }

        return result;
    }
}
