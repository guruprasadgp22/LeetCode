class Solution {
    public int numOfSubarrays(int[] arr) {
        int n = arr.length;
        long sum = 0;
        int even = 1;
        int res = 0;
        int odd = 0;
        int MOD = 1_000_000_007;
        for(int i=0;i<n;i++) {
            sum += arr[i];
            if(sum % 2 == 0) {
                res = (res + odd) % MOD;
                even++;
            } else {
                res =(res + even) % MOD;
                odd++;
            }
        }
        return res;
    }
}
