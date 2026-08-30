class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        int minEle = Integer.MAX_VALUE;
        int maxEle = Integer.MIN_VALUE;
        int minEleIndex = -1;
        int maxEleIndex = -1;

        for(int i=0;i<n;i++) {
            if(minEle > nums[i]) {
                minEle = nums[i];
                minEleIndex = i;
            }

            if(maxEle < nums[i]) {
                maxEle = nums[i];
                maxEleIndex = i;
            }
        }

        int leftIndex = Math.min(minEleIndex, maxEleIndex);
        int rightIndex = Math.max(minEleIndex, maxEleIndex);

        int case1 = leftIndex + 1 + n - rightIndex;
        int case2 = rightIndex + 1;
        int case3 = n - leftIndex;

        return Math.min(case3, Math.min(case1, case2));
    }
}
