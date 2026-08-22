class Solution {
    public boolean checkDivisibility(int n) {
        int t = n;
        int product = 1;
        int sum = 0;

        while(t > 0) {
            int temp = t % 10;
            product *= temp;
            sum += temp;
            t /= 10;
        }

        return n % (product + sum) == 0;
    }
}
