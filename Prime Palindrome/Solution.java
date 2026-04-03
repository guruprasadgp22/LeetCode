class Solution {
    public int primePalindrome(int n) {
       
        if (n <= 2) return 2;
        if (n <= 3) return 3;
        if (n <= 5) return 5;
        if (n <= 7) return 7;
        if (n <= 11) return 11;

        for (int i = 1; i < 100000; i++) {

            String s = Integer.toString(i);
            String rev = new StringBuilder(s.substring(0, s.length() - 1)).reverse().toString();
            int palindrome = Integer.parseInt(s + rev);

            if (palindrome >= n && isPrime(palindrome)) {
                return palindrome;
            }
        }

        return -1;

    }
    public boolean isPalindrome(int num) {
        int temp = num;
        int res = 0;
        while(num > 0) {
            int t = num % 10;
            res = res * 10 + t;
            num /= 10;
        }

        return res == temp;
    }

    public boolean isPrime(int num) {
        if(num < 2) {
            return false;
        }

        if(num == 2 || num == 3) {
            return true;
        }

        if(num % 2 == 0 || num % 3 == 0) {
            return false;
        }

        for(int i=5;i*i <= num; i+=6) {
            if(num % i == 0 || num % (i+2) == 0) {
                return false;
            }
        }

        return true;
    }
}
