class Pair {
    int u;
    int v;

    Pair(int u, int v) {
        this.u = u;
        this.v = v;
    }
}

class Solution {
    int[] rank;
    int parent[];

    private boolean union(int u, int v) {
        int parentU = find(u);
        int parentV = find(v);

        if(parentU == parentV) {
            return false;
        }

        if(rank[parentU] == rank[parentV]) {
            parent[parentV] = parentU;
            rank[parentU] += 1;
        } else if(rank[parentU] > rank[parentV]) {
            parent[parentV] = parentU;
        } else {
            parent[parentU] = parentV;
        }

        return true;
    }

    private int find(int x) {
        if(x == parent[x]) {
            return parent[x];
        }

        return find(parent[x]);
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;

        rank = new int[n+1];
        parent = new int[n+1];

        for(int i=1;i<=n;i++) {
            rank[i] = 0;
            parent[i] = i;
        }

        Queue<Pair> queue = new LinkedList<>();
        for(int[] edge: edges) {
            int u = edge[0];
            int v = edge[1];
            queue.add(new Pair(u, v));
        }

        while(!queue.isEmpty()) {
            Pair temp = queue.poll();
            if(!union(temp.u, temp.v)) {
                return new int[] {temp.u, temp.v};
            }
        }

        return new int[] {};
    }
}
