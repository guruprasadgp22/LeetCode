class Solution {
    public int numberOfMatches(int n) {
        int matches = 0;

        while(n > 1) {
            if(n % 2 != 0) {
                n = (n-1)/2;
                matches += n;
                n += 1;
            } else {
                n /= 2;
                matches += n;
            }
        }

        return matches;
    }
}
