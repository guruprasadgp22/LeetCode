class Solution {
    int m;
    int n;
    public int closedIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        int count = 0;

        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j] == 0) {
                    if(DFS(i, j, grid)) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    private boolean DFS(int i, int j, int[][] grid) {
        if(i < 0 || j < 0 || i >= m || j >= n) {
            return false;
        }
        if(grid[i][j] == 1) {
            return true;
        }

        grid[i][j] = 1;
        boolean left = DFS(i,j-1,grid);
        boolean down = DFS(i+1, j, grid);
        boolean right = DFS(i, j+1, grid);
        boolean up = DFS(i-1, j, grid);

        return left & down & right & up;
    }
}
