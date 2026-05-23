class Solution {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        long sum = 0;
        long fo = 0;

        for(int i=0;i<n;i++) {
            sum += (long) nums[i];

            fo += (long) i * nums[i];
        }

        long curr = fo;
        long res = fo;

        for(int i=n-1;i>0;i--) {
            curr = sum + curr - (long) n * nums[i];
            res = Math.max(res, curr);
        }

        return (int)res;
    }
}
