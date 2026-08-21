class Solution {
    public long findKthSmallest(int[] coins, int k) {
        long result = -1;
        int maxElement = 0;

        for(int ele: coins) {
            maxElement = Math.max(ele, maxElement);
        }

        long left = 1;
        long right = (long) maxElement * k;

        while(left <= right) {
            long mid = left + (right - left)/2;

            if(countSmaller(mid, coins) >= k) {
                result = mid;
                right = mid -1 ;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }

    private long countSmaller(long mid, int[] coins) {
        long correctedCount = 0;

        int n = coins.length;

        for(int expression=1;expression <= (1 << n)-1; expression++) {
            long order = 0;
            long LCM = 0;

            for(int i=0;i<n;i++) {
                if((expression & (1 << i)) != 0) {
                    order++;

                    if(LCM == 0) {
                        LCM = coins[i];
                    } else {
                        LCM = (coins[i] * LCM)/GCD(LCM, coins[i]);
                    }
                }
            }

            if(order % 2 == 0) {
                correctedCount -= mid/LCM;
            } else {
                correctedCount += mid/LCM;
            }
        }

        return correctedCount;
    }

    private long GCD(long a, long b) {
        while( b!= 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }
}
