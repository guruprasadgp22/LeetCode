class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        int len = original.length;
        if(len != m*n) {
            return new int[][]{};
        }
        int k = 0;
        int[][] res = new int[m][n];
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                res[i][j] = original[k++];
            }
        }

        return res;
    }
}
