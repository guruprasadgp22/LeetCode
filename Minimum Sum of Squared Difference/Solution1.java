class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        int[] countDiff = new int[100001];
        for(int i=0;i<n;i++) {
            int diff = Math.abs(nums1[i] - nums2[i]);
            countDiff[diff]++;
        }

        int k = k1 + k2;
        long result = 0;

        for(int currDiff = 100000; currDiff > 0 &&  k > 0; currDiff--) {
            int countOps = Math.min(countDiff[currDiff], k);
            countDiff[currDiff] -= countOps;
            countDiff[currDiff - 1] += countOps;
            k -= countOps;
        }

        for(int i = 1;i<100001;i++) {
            result += (long)i * i * countDiff[i];
        }

        return result;
    }
}
