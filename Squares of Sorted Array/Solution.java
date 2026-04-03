class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] ans = new int[nums.length];
        int i = 0;
        for(int ele: nums) {
            ans[i++] = ele * ele;
        }

        Arrays.sort(ans);

        return ans;
    }
}
