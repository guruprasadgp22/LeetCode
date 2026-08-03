class Solution {
    int time;
    int[] dt;
    int low[];
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        time = 0;
        dt = new int[n];
        Arrays.fill(dt, -1);
        low = new int[n];

        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++) {
            graph.add(new ArrayList<>());
        }

        for(List<Integer> ls: connections) {
            int u = ls.get(0);
            int v = ls.get(1);
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        List<List<Integer>> result = new ArrayList<>();

        for(int i=0;i<n;i++) {
            if(dt[i] == -1) {
                DFS(i, -1, graph, result);
            }
        }

        return result;
    }

    private void DFS(int u, int parentU, List<List<Integer>> graph, List<List<Integer>> result) {
        dt[u] = low[u] = ++time;

        for(int v: graph.get(u)) {
            if(dt[v] == -1) {
                DFS(v, u, graph, result);
                low[u] = Math.min(low[u], low[v]);

                if(low[v] > dt[u]) {
                    List<Integer> ans = new ArrayList<>();
                    ans.add(u);
                    ans.add(v);
                    result.add(ans);
                }
            } else if(v != parentU) {
                low[u] = Math.min(low[u], dt[v]);
            }
        }
    }
}
