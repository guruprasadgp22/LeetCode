class Solution {
    public int maxFrequency(int[] nums, int k) {
        int n = nums.length;

        Arrays.sort(nums);

        int[] prefixSum = new int[n];
        prefixSum[0] = nums[0];
        for(int i=1;i<n;i++) {
            prefixSum[i] = prefixSum[i-1] + nums[i];
        }

        int result = 1;
        for(int i  = 0;i<n;i++) {
            result = Math.max(result, binarySearch(i, nums, k, prefixSum));
        }

        return result;
    }

    private int binarySearch(int targetIdx, int[] arr, int k, int[] prefixSum) {
        int left = 0;
        int right = targetIdx;
        int res = targetIdx;

        int targetEle = arr[targetIdx];

        while(left <= right) {
            int mid = left + (right - left)/2;

            int count = (targetIdx - mid + 1);
            int modifiedSum = count * targetEle;
            int currSum = prefixSum[targetIdx] - prefixSum[mid] + arr[mid];
            int op = modifiedSum - currSum;

            if(op > k) {
                left = mid + 1;
            } else {
                res = mid;
                right = mid - 1;
            }
        }

        return targetIdx - res + 1;
    }
}
