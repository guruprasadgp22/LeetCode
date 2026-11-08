class Solution {
    public boolean divideArray(int[] nums) {
        boolean[] freq = new boolean[501];
        Arrays.fill(freq, true);
        for (int ele : nums) {
            freq[ele] = !freq[ele];
        }

        for (boolean ele : freq) {
            if (!ele) {
                return false;
            }
        }
        return true;
    }
}
