class Solution {
    public boolean predictTheWinner(int[] nums) {
        int sum = 0;
        for(int ele: nums) {
            sum += ele;
        }

        int p1 = solve(0, nums.length-1, nums);

        if(sum-p1 > p1) {
            return false;
        }

        return true;
    }

    int solve(int start, int end, int[] arr) {

        if(start > end) {
            return 0;
        }

        int sum_start = arr[start] + Math.min(solve(start+2, end, arr), solve(start+1, end-1, arr));
        int sum_end = arr[end] + Math.min(solve(start+1, end-1, arr), solve(start, end-2, arr));

        return Math.max(sum_start, sum_end);
    }
}
