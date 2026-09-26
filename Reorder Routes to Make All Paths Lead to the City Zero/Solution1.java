class Solution {
    public int minReorder(int n, int[][] connections) {
        List<List<int[]>> adjMat = new ArrayList<>();
        for(int i=0;i<n;i++) {
            adjMat.add(new ArrayList<>());
        }

        for(int[] x: connections) {
            int u = x[0];
            int v = x[1];
            adjMat.get(u).add(new int[]{v, 1});
            adjMat.get(v).add(new int[]{u, 0});
        }

        boolean[] visited = new boolean[n];
        return DFS(0, visited, adjMat);
    }

    private int DFS(int source, boolean[] visited, List<List<int[]>> adjMat) {
        visited[source] = true;
        int max = 0;

        for(int[] x: adjMat.get(source)) {
            int v = x[0];
            int cost = x[1];

            if(!visited[v]) {
                max += cost + DFS(v, visited, adjMat);
            }
        }

        return max;
    }
}
