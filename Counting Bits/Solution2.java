class Solution {
    public int[] countBits(int n) {
        int[] result = new int[n+1];
        if(n==0) {
            return result;
        }

        result[1] = 1;
        if(n ==1) {
            return result;
        }
        for(int i=2;i<=n;i++) {
            result[i] = result[i/2];
            if(i%2 == 1) {
                result[i] +=1;
            }
        }

        return result;
    }
}
