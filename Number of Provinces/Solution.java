class Solution {
    public int findCircleNum(int[][] isConnected) {
        int count = 0;
        int n = isConnected.length;
        boolean[] visited = new boolean[n];

        for(int i=0;i<n;i++) {
            if(!visited[i]) {
                dfs(i, isConnected, visited);
                count++;
            }
        }

        return count;
    }

    private void dfs(int source, int[][] graph, boolean[] visited) {
        visited[source] = true;

        for(int i=0;i<graph.length;i++) {
            if(graph[source][i] == 1 && !visited[i]) {
                dfs(i, graph, visited);
            }
        }
    }
}
