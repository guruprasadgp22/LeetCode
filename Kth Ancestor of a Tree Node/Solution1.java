class TreeAncestor {
    int[][] ancestor;

    public TreeAncestor(int n, int[] parent) {
        int cols =(int)(Math.log(n) / Math.log(2) + 1e-11) + 1;
        ancestor = new int[n][cols];
        for (int[] x : ancestor) {
            Arrays.fill(x, -1);
        }

        for (int i = 0; i < n; i++) {
            ancestor[i][0] = parent[i];
        }

        for (int j = 1; j < ancestor[0].length; j++) {
            for (int node = 0; node < n; node++) {
                if (ancestor[node][j - 1] != -1) {
                    ancestor[node][j] = ancestor[ancestor[node][j - 1]][j - 1];
                }
            }
        }
    }

    public int getKthAncestor(int node, int k) {
        for (int j = 0; j < ancestor[0].length; j++) {
            if ((k & (1 << j)) != 0) {
                node = ancestor[node][j];
                if (node == -1) {
                    return -1;
                }
            }
        }

        return node;
    }
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */
