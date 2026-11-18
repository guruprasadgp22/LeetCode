class Solution {
    public int differenceOfSums(int n, int m) {
        int k = n/m;
        int kSum = m * ((k * (k + 1))/ 2);
        int sum = (n * (n+1))/2;
        return sum - 2 *kSum;
    }
}
