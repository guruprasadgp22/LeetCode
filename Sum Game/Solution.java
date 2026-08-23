class Solution {
    public boolean sumGame(String num) {
        int leftKnownSum = 0;
        int rightKnownSum = 0;
        int leftQnMrkCnt = 0;
        int rightQnMrkCnt = 0;
        int n = num.length();

        for(int i=0;i<n;i++) {
            if(num.charAt(i) == '?') {
                if(i < n/2) {
                    leftQnMrkCnt++;
                } else {
                    rightQnMrkCnt++;
                }
            } else {
                if(i < n/2) {
                    leftKnownSum += num.charAt(i) - '0';
                } else {
                    rightKnownSum += num.charAt(i) - '0';
                }
            }
        }

        if((leftQnMrkCnt + rightQnMrkCnt) % 2 == 1) {
            return true;
        }

        int left = 2 * leftKnownSum + 9 * leftQnMrkCnt;
        int right = 2 * rightKnownSum + 9 * rightQnMrkCnt;

        if(left == right) {
            return false;
        }

        return true;
    }
}
