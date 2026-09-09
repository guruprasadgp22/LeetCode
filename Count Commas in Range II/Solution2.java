class Solution {
    public long countCommas(long n) {
        long result = 0;
        long start = 1000;
        while(start <= n) {
            long count = n - start + 1;
            result += count;
            start *= 1000;
        }

        return result;
    }
}
