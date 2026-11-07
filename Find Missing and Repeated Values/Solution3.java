class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        long n = grid.length * grid.length;
        long sum = 0;
        long sqSum = 0;
        for(int[] x: grid) {
            for(int ele: x) {
                sum += ele;
                sqSum += ele * ele;
            }
        }
       
        long naturalSum = (n * (n+1))/2;
        long naturalSqSum = (n * (n+1)*(2*n+1))/6;
        long sumDiff = sum - naturalSum;
        long sqSumDiff = sqSum - naturalSqSum;
        int a = (int)(sumDiff + (sqSumDiff/sumDiff))/2;
        int b = (int)((sqSumDiff/sumDiff) - sumDiff)/2;
        return new int[]{a, b};
    }
}
