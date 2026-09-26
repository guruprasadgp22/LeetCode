class Solution {
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] res = new int[n-2][n-2];

        for(int i=0;i<n-2;i++) {
            for(int j=0;j<n-2;j++) {
                res[i][j] = findMaxEle(grid, i, j);
            }
        }

        return res;
    }

    private int findMaxEle(int[][] mat, int row, int col) {

        int max = Integer.MIN_VALUE;

        for(int i=row;i < row + 3; i++) {
            for(int j=col;j<col+3;j++) {
                max = Math.max(mat[i][j], max);
            }
        }

        return max;
    }
}
