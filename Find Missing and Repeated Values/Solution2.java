class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length * grid.length + 1;
        int[] freq = new int[n];
        for(int[] x: grid) {
            for(int ele: x) {
                freq[ele]++;
            }
        }
        int[] res = new int[2];

        for(int i = 1;i<n;i++) {
            if(freq[i] == 0) {
                res[1] = i;
            } else if(freq[i] == 2) {
                res[0] = i;
            }
        }

        return res;
    }
}
