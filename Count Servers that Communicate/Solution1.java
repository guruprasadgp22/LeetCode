class Solution {
    public int countServers(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j] == 1) {
                    boolean got = false;

                    for(int row=0;row<m;row++) {
                        if(grid[row][j] == 1 && row != i) {
                            got = true;
                            break;
                        }
                    }

                    if(got) {
                        count++;
                    } else {
                        for(int col=0;col<n;col++) {
                            if(grid[i][col] == 1 && col != j) {
                                got= true;
                                break;
                            }
                        }

                        if(got) {
                            count++;
                        }
                    }
                }
            }
        }

        return count;
    }
}
