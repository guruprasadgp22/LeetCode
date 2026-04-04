class Solution {
    public int maximumPrimeDifference(int[] nums) {
        int minIndex = 0;

        while(minIndex < nums.length) {
            if(isPrime(nums[minIndex])) {
                break;
            }
            minIndex++;
        }

        int maxIndex = nums.length - 1;

        while(maxIndex >= 0) {
            if(isPrime(nums[maxIndex])) {
                break;
            }
            maxIndex--;
        }

        return Math.abs(maxIndex - minIndex);
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
