class Solution {
    private boolean tisValid(long num) {
        int[] arr = {2,3,5,7};

        for(int prime: arr) {
            while(num % prime == 0) {
                num /= prime;
            }
        }

        return num == 1;
    }

    private long GCD(long a, long b) {

        while(b != 0) {
            long temp = a%b;
            a = b;
            b = temp;
        }

        return a;
    }

    public String smallestNumber(String num, long t) {
         int n = num.length();

         if(!tisValid(t)) {
            return "-1";
         }

         long remainingFactor[] = new long[n+1];
         remainingFactor[0] = t;
         for(int i=0;i<n;i++) {
            int digit = num.charAt(i) - '0';
            if(digit == 0) {
                break;
            }

            remainingFactor[i+1] = remainingFactor[i]/GCD(remainingFactor[i], (long)digit);
         }

         if(remainingFactor[n] == 1) {
            return num;
         }

         int zeroPos = num.indexOf('0');
         int startIndex = zeroPos == -1? n-1: zeroPos;

         for(int i=startIndex; i>=0;i--) {
            long required =  remainingFactor[i];
            int freeSlot = n-i-1;

            for(int digit = (num.charAt(i) - '0') + 1; digit<= 9; digit++) {
                long furtherRequired = required / GCD(required, (long)digit);
                String suffix = formANumber(furtherRequired, freeSlot);

                if(suffix.length() == freeSlot) {
                    return num.substring(0, i) + digit + suffix;
                }
            }
         }

         return formANumber(t, n+1);
    }

    private String formANumber(long num, int len) {
        StringBuilder sb = new StringBuilder();

        for(int i=9;i>=2;i--) {
            while(num%i == 0) {
                sb.append(i);
                num /= i;
            }
        }

        while(sb.length() < len) {
            sb.append(1);
        }

        sb.reverse();

        return sb.toString();
    }
}
