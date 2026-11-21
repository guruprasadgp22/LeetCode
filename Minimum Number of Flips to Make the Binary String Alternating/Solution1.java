class Solution {
    public int minFlips(String s) {
        String str = s + s;
        int n = s.length();
        String res1 = "01".repeat(n);
        String res2 = "10".repeat(n);

        int result1 = 0;
        int result2 = 0;

        for(int i=0;i<n;i++) {
            if(str.charAt(i) != res1.charAt(i)) {
                result1++;
            }

            if(str.charAt(i) != res2.charAt(i)) {
                result2++;
            }
        }

        int minFlip = Math.min(result1, result2);

        for(int i=n;i<2*n;i++) {
            if(str.charAt(i) != res1.charAt(i)) {
                result1++;
            }

            if(str.charAt(i-n) != res1.charAt(i-n)) {
                result1--;
            }

            if(str.charAt(i) != res2.charAt(i)) {
                result2++;
            }

            if(str.charAt(i-n) != res2.charAt(i-n)) {
                result2--;
            }

            minFlip = Math.min(minFlip, Math.min(result1, result2));
        }

        return minFlip;
    }
}
