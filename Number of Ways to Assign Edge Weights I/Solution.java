class Solution {
    final long mod = 1_000_000_007;
    public int assignEdgeWeights(int[][] edges) {
        int n = edges.length + 1;

        List<Integer>[] graph = new ArrayList[n+1];
        for(int i=1;i<=n;i++) {
            graph[i] = new ArrayList<>();
        }
        for(int[] e: edges) {
            int u = e[0];
            int v = e[1];
            graph[u].add(v);
            graph[v].add(u);
        }

        int maxDepth = DFS(1, -1, graph);

        return power(2, maxDepth-1);
    }

    private int DFS(int source, int parent, List<Integer>[] graph) {
        int depth = 0;

        for(int ele: graph[source]) {
            if(ele != parent) {
                depth = Math.max(depth, 1+DFS(ele, source, graph));
            }
        }

        return depth;
    }

    private int power(int b, int e) {
        long ans = 1;
        long base = b % mod;

        while(e > 0) {
            if((e & 1) == 1) {
                ans = (ans * base) % mod;
            }

            base = (base * base) % mod;
            e = e>>1;
        }

        return (int)ans;
    }
}
