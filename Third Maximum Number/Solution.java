class Solution {
    public int thirdMax(int[] nums) {
        long max = Long.MIN_VALUE;
        long secondMax = Long.MIN_VALUE;
        long thirdMax = Long.MIN_VALUE;

        for (int n: nums){
            if (n > max){
                thirdMax = secondMax;
                secondMax = max;
                max = n;
            }
            else if (n>secondMax && n<max){
                thirdMax = secondMax; 
                secondMax = n;
            }
            else if (n>thirdMax && n<secondMax)
                thirdMax = n;
        }
        return (thirdMax != Long.MIN_VALUE) ? (int)thirdMax : (int)max;
    }
}
