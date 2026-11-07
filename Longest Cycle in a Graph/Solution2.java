class Solution {
    int result = -1;
    public int longestCycle(int[] edges) {
        int n = edges.length;
        boolean[] visited = new boolean[n];
        boolean[] recursion = new boolean[n];
        int[] count = new int[n];
        Arrays.fill(count, 1);

        for(int i=0;i<n;i++) {
            if(!visited[i]) {
                DFS(i, edges, visited, recursion, count);
            }
        }

        return result;
    }

    private void DFS(int u, int[] arr, boolean[] visited, boolean[] recursion, int[] count) {
        if(arr[u] != -1) {
            visited[u] = true;
            recursion[u] = true;

            int v = arr[u];

            if(v != -1 && !visited[v]) {
                count[v] = count[u] + 1;
                DFS(v, arr, visited, recursion, count);
            } else if(recursion[v]) {
                result = Math.max(result, count[u] - count[v] + 1);
            }

            recursion[u] = false;
        }
    }
}
