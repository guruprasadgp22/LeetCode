class Solution {
    public long countCommas(long n) {
        long result = 0;
        long commas = 1;
        long lower = 1000;

        while(lower <= n) {
            long upper = (lower * 1000) - 1;
            if(upper > n) {
                upper = n;
            }

            long count = upper - lower + 1;
            result += (count * commas);
            commas++;
            lower *= 1000;
        }

        return result;
    }
}
