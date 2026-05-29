class Solution {
    public int minElement(int[] nums) {
        int minElement = Integer.MAX_VALUE;

        for(int ele: nums) {
            minElement = Math.min(minElement, sumOfDigit(ele));
        }

        return minElement;
    }

    public int sumOfDigit(int num) {
        int sum = 0;
        while(num > 0) {
            sum += num % 10;
            num /= 10;
        }

        return sum;
    }
}
