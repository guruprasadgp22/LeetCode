class Solution {
    public int[] findOrder(int n, int[][] edges) {
        boolean[] visited = new boolean[n];
        boolean[] recursivePath = new boolean[n];

        for(int i=0;i<n;i++) {
            if(!visited[i]) {
                if(DFS(i, visited, recursivePath, edges)) {
                    return new int[] {};
                }
            }
        }

        boolean[] vis = new boolean[n];
        Stack<Integer> ans = new Stack<>();

        for(int i=0;i<n;i++) {
            if(!vis[i]) {
                DFSTopo(i, vis, ans, edges);
            }
        }

        int[] result = new int[ans.size()];
        int i = 0;

        while(ans.size() > 0) {
            result[i++] = ans.pop();
        }

        return result;
    }

    public void DFSTopo(int source, boolean[] vis, Stack<Integer> ans, int[][] edges) {
        vis[source] = true;

        for(int i=0;i<edges.length;i++) {
            int v = edges[i][0];
            int u = edges[i][1];

            if(source == u) {
                if(!vis[v]) {
                    DFSTopo(v, vis, ans, edges);
                }
            }
        }

        ans.add(source);
    }

    public boolean DFS(int source, boolean[] visited, boolean recursivePath[], int[][] edges) {
        visited[source] = true;
        recursivePath[source] = true;

        for(int i=0;i<edges.length;i++) {
            int v = edges[i][0];
            int u = edges[i][1];

            if(u == source) {
                if(!visited[v]) {
                    if(DFS(v, visited, recursivePath, edges)) {
                        return true;
                    }
                } else if(recursivePath[v]) {
                    return true;
                }
            }
        }

        recursivePath[source] = false;
        return false;
    }
}
