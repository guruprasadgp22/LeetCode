class Solution {
    int mod = 1_000_000_007;
	int[] depth;
	HashMap<Integer, List<Integer>> map;
	int lift[][];
	
	public int[] assignEdgeWeights(int[][] edges, int[][] queries) {
		int n = edges.length + 1;
		depth = new int[n+1];
		map = new HashMap<>();
		lift = new int[n+1][18];
		
//		Adjacency list
		for(int ele[]: edges) {
			int u = ele[0];
			int v = ele[1];
			map.putIfAbsent(u, new ArrayList<>());
			map.putIfAbsent(v, new ArrayList<>());
			map.get(u).add(v);
			map.get(v).add(u);
		}
		
//		DFS
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[n+1];
		queue.add(1);
		visited[1] = true;
		lift[1][0] = 1;
		
		while(!queue.isEmpty()) {
			int source = queue.poll();
			
			for(int neigh: map.get(source)) {
				if(!visited[neigh]) {
					depth[neigh] = depth[source] + 1;
					queue.add(neigh);
					visited[neigh] = true;
					lift[neigh][0] = source; 
				}
			}
		}
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<18;j++) {
				lift[i][j] = lift[lift[i][j-1]][j-1];
			}
		}
		
		int[] ans = new int[queries.length];
		for(int i=0;i<queries.length;i++) {
			int u = queries[i][0];
			int v = queries[i][1];
			int dist = depth[u] + depth[v] - 2 * depth[lca(u,v)];
			ans[i] = (dist == 0)? 0: power(2, dist-1);
		}
		
		return ans;
    }
	
	private int power(int b, int e) {
		long ans = 1;
		long base = b % mod;
		
		while(e > 0) {
			if((e & 1) == 1) {
				ans = (ans * base) % mod;
			}
			base = (base * base) % mod;
			e = e >> 1;
		}
		
		return (int) ans;
	}

	private int lca(int u, int v) {
		if(depth[u] < depth[v]) {
			return lca(v, u);
		}
		
		int diff = depth[u] - depth[v];
		
		for(int i=0;i<18;i++) {
			if(((diff >> i) & 1) == 1) {
				u = lift[u][i];
			}
		}
		
		if(u == v) {
			return u;
		}
		
		for(int i=17;i>=0;i--) {
			if(lift[u][i] != lift[v][i]) {
				u = lift[u][i];
				v = lift[v][i];
			}
		}
		
		return lift[u][0];
	}
}
