class Solution {
    public int smallestNumber(int n, int t) {
        
        while(true) {
            if(solve(n, t)) {
                return n;
            }
            n++;
        }

    }

    private boolean solve(int n, int t) {
        int product = 1;

        while(n > 0) {
            int temp = n%10;
            product *= temp;
            n /= 10;
        }

        return product%t==0;
    }
}
