class Solution {
    public int orangesRotting(int[][] grid) {
        int[] dy = {1, 0, -1, 0};
        int[] dx = {0, 1, 0, -1};

        int m = grid.length;
        int n = grid[0].length;
        int one = 0;

        Queue<int[]> queue = new LinkedList<>();
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j] == 2){
                    queue.add(new int[]{i, j});
                } else if(grid[i][j] == 1){
                    one++;
                }
            }
        }

        if(one == 0) {
            return 0;
        }

        int time = -1;

        while(!queue.isEmpty()) {
            int size = queue.size();

            while(size > 0) {
                int[] temp = queue.poll();
                int u = temp[0];
                int v = temp[1];

                for(int i=0;i<4;i++) {
                    int x = u + dx[i];
                    int y = v + dy[i];

                    if(x >= 0 && y >= 0 && x < m && y < n && grid[x][y] == 1) {
                        queue.add(new int[]{x, y});
                        grid[x][y] = 2;
                        one--;
                    }
                }
                size--;
            }
            time++;
        }

        return one == 0? time: -1;
    }
}
