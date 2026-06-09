class Pair {
    int i;
    int j;

    Pair(int i, int j) {
        this.i = i;
        this.j = j;
    }
}

class DoublePair {
    Pair pair;
    int time;

    DoublePair(Pair pair, int time) {
        this.pair = pair;
        this.time = time;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<DoublePair> queue = new LinkedList<>();

        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j] == 2) {
                    queue.add(new DoublePair(new Pair(i, j), 0));
                }
            }
        }

        int ans = 0;

        while(!queue.isEmpty()) {
            DoublePair temp = queue.poll();
            int i = temp.pair.i;
            int j = temp.pair.j;
            int time = temp.time;

            ans = Math.max(ans, time);

            if(i-1 >= 0 && !visited[i-1][j] && grid[i-1][j] == 1) {
                queue.add(new DoublePair(new Pair(i-1, j), time+1));
                visited[i-1][j] = true;
            }

            if(j+1 < n && !visited[i][j+1] && grid[i][j+1] == 1) {
                queue.add(new DoublePair(new Pair(i, j+1), time+1));
                visited[i][j+1] = true;
            }

            if(i+1 < m && !visited[i+1][j] && grid[i+1][j] == 1) {
                queue.add(new DoublePair(new Pair(i+1, j), time+1));
                visited[i+1][j] = true;
            }

            if(j-1 >= 0 && !visited[i][j-1] && grid[i][j-1] == 1) {
                queue.add(new DoublePair(new Pair(i, j-1), time+1));
                visited[i][j-1] = true;
            }
        }

        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j] == 1 && !visited[i][j]) {
                    return -1;
                }
            }
        }

        return ans;
    }
}
