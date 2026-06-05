class Solution {
    public boolean checkValidGrid(int[][] grid) {
        int n = grid.length;
        int row = 0;
        int col = 0;
        int exceVal = 0;

        return isValid(grid, n, row, col, exceVal);
    }

    public boolean isValid(int grid[][], int n, int row, int col, int k) {
        if(row >= n || col >= n || col < 0 || row < 0 || grid[row][col] != k) {
            return false;
        }

        if(k == n*n-1) {
            return true;
        }

        return isValid(grid, n, row-2, col + 1, k + 1) ||
                isValid(grid, n, row-1, col + 2, k + 1) ||
                isValid(grid, n, row+1, col + 2, k + 1) ||
                isValid(grid, n, row+2, col + 1, k + 1) ||
                isValid(grid, n, row+2, col - 1, k + 1) ||
                isValid(grid, n, row+1, col - 2, k + 1) ||
                isValid(grid, n, row-1, col - 2, k + 1) ||
                isValid(grid, n, row-2, col - 1, k + 1);
    }
}
