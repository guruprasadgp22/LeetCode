class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int[] freq = new int[100];
        for(int[] x: dominoes) {
            if(x[0] > x[1]) {
                int t = x[0];
                x[0] = x[1];
                x[1] = t; 
            }
            int num = x[0] * 10 + x[1];
            freq[num]++;
        }

        int count = 0;
        for(int ele: freq) {
            if(ele > 1) {
                count += (ele * (ele - 1))/2;
            }
        }
        return count;
    }
}
