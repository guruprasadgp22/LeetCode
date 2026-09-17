class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int i = 0;
        int j = 0;
        int minLen = Integer.MAX_VALUE;
        int result = Integer.MAX_VALUE;
        int currentSum = 0;

        int[] minLenTillIdx = new int[arr.length];
        Arrays.fill(minLenTillIdx, Integer.MAX_VALUE);

        while(j < arr.length) {
            currentSum += arr[j];

            while(currentSum > target) {
                currentSum -= arr[i];
                i++;
            }    

            if(currentSum == target) {
                int len = j - i + 1;

                if(i > 0 && minLenTillIdx[i-1] != Integer.MAX_VALUE) {
                    result = Math.min(result, len + minLenTillIdx[i-1]);
                }

                minLen = Math.min(minLen, len);
            }

            minLenTillIdx[j] = minLen;
            j++;
        }

        return result == Integer.MAX_VALUE? -1: result;
    }
}
