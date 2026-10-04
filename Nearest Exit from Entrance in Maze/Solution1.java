class Pair {
    int u;
    int v;

    Pair(int u, int v) {
        this.u = u;
        this.v = v;
    }
}

class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int start = entrance[0];
        int end = entrance[1];

        int m = maze.length;
        int n = maze[0].length;

        boolean[][] visited = new boolean[m][n];
        Queue<Pair> queue = new LinkedList<>();
        
        queue.add(new Pair(start, end));
        visited[start][end] = true;

        int steps = 0;

        while(!queue.isEmpty()) {
            int size = queue.size();

            while(size > 0) {
                Pair temp = queue.poll();
                int u = temp.u;
                int v = temp.v;

                boolean entry = start == u && end == v;
                boolean step = u == 0 || v == 0 || u == m-1 || v == n-1;

                if(!entry && step) {
                    return steps;
                }
                
                for(int i=0;i<4;i++) {
                    int x = dx[i] + u;
                    int y = dy[i] + v;

                    if(x >= 0 && y >= 0 && x < m && y < n && !visited[x][y] && maze[x][y] == '.') {
                        visited[x][y] = true;
                        queue.add(new Pair(x, y));
                    }
                }
                size--;
            }

            steps++;
        }

        return -1;
    }
}
