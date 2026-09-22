class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] result = new long[k];
        long[] count = new long[k];

        for(int num: nums) {
            int numRem = num % k;

            long[] newCount = new long[k];
            newCount[numRem] = 1;

            for(int oldRem = 0; oldRem < k; oldRem++) {
                int newRem = (oldRem * numRem) % k;
                newCount[newRem] += count[oldRem];
            }

            for(int i=0;i<k;i++) {
                result[i] += newCount[i];
            }

            count = newCount;
        }

        return result;
    }
}
