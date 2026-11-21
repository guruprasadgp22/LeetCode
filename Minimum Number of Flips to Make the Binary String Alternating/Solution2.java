class Solution {
    public int minFlips(String str) {
        int n = str.length();
        int result1 = 0;
        int result2 = 0;
        for(int i=0;i<n;i++) {
            char ch1 = i % 2 == 0? '0':'1';
            char ch2 = i % 2 == 1? '0':'1';
            if(str.charAt(i) != ch1) {
                result1++;
            }

            if(str.charAt(i) != ch2) {
                result2++;
            }
        }

        int minFlip = Math.min(result1, result2);

        for(int i=n;i<2*n;i++) {
            char ch1 = i % 2 == 0? '0':'1';
            char ch2 = i % 2 == 1? '0':'1';
            char prevCh1 = (i - n) % 2 == 0? '0':'1';
            char prevCh2 = (i - n) % 2 == 1? '0':'1';
            if(str.charAt(i%n) !=ch1) {
                result1++;
            }

            if(str.charAt(i%n) != prevCh1) {
                result1--;
            }

            if(str.charAt(i%n) != ch2) {
                result2++;
            }

            if(str.charAt(i%n) != prevCh2) {
                result2--;
            }

            minFlip = Math.min(minFlip, Math.min(result1, result2));
        }

        return minFlip;
    }
}
