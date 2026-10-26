class Solution {
    int m;
    int n;
    int k;

    public int countIslands(int[][] grid, int k) {
        int count = 0;
        m = grid.length;
        n = grid[0].length;
        this.k = k;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) {
                    if (DFS(grid, i, j) == 0) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    private int DFS(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == 0) {
            return 0;
        }

        int sum = grid[i][j];
        grid[i][j] = 0;
        sum += DFS(grid, i + 1, j) + DFS(grid, i - 1, j) + DFS(grid, i, j + 1) + DFS(grid, i, j - 1);
        return sum % k;
    }
}
