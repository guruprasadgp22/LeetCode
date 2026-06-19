class Solution {
    public int largestAltitude(int[] gain) {
        int current = 0;
        int max = 0;
        for(int ele: gain) {
            current = current + ele;
            max = Math.max(current, max);
        }
        return max;
    }
}
