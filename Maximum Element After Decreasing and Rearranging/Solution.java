class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);

        int prev = 0;

        for(int ele: arr) {
            prev = Math.min(prev + 1, ele);
        }

        return prev;
    }
}
