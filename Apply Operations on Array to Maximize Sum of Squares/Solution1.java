class Solution {
    int MOD = 1_000_000_007;
    public int maxSum(List<Integer> nums, int k) {
        int[] countFreq = new int[32];
        for(int num: nums) {
            for(int b=0;b<32;b++) {
                if((num & (1 << b)) != 0) {
                    countFreq[b]++;
                }
            }
        }

        long result = 0;

        while(k-- > 0) {
            int curr = 0;
            for(int b=0;b<32;b++) {
                if(countFreq[b] > 0) {
                    countFreq[b]--;
                    curr = (curr | (1 << b));
                }
            }

            result = (result + ((long)curr * curr)) % MOD;
        }

        return (int)result;
    }
}
