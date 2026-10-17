class Solution {
    public int[] countBits(int n) {
        int[] result = new int[n+1];
        for(int i=0;i<=n;i++) {
            result[i] = solve(i);
        }
        return result;
    }

    private int solve(int num) {
        int one = 0;
        while(num > 0) {
            if(num % 2 == 1) {
                one++;
            }

            num /= 2;
        }

        return one;
    }
}
