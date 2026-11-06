class SegmentTree {
    int n;
    int[] tree;

    SegmentTree(int[] arr) {
        this.n = arr.length;
        tree = new int[4*n];
        build(0, 0, n-1, arr);
    }

    void build(int i, int start, int end, int[] arr) {
        if(start == end) {
            tree[i] = arr[start];
            return;
        }
        int mid = start + (end - start)/2;
        build(2*i+1, start, mid, arr);
        build(2*i+2, mid+1, end, arr);
        tree[i] = tree[2*i+1] ^ tree[2*i+2];
    }

    void update(int index, int val) {
        update(0, 0, n-1, index, val);
    }

    void update(int i, int start, int end, int index, int val) {
        if(start == end) {
            tree[i] = val;
            return; 
        }

        int mid = start + (end - start)/2;
        if(index <= mid) {
            update(2*i+1, start, mid, index, val);
        } else {
            update(2*i+2, mid+1, end, index, val);
        }

        tree[i] = tree[2*i+1]^tree[2*i+2];
    }

    int query(int left, int right) {
        return query(0, 0, n-1, left, right);
    }

    int query(int i, int start, int end, int left, int right) {
        if(left > end || right < start) {
            return 0;
        }

        if(left <= start && right >= end) {
            return tree[i];
        }

        int mid = start + (end - start)/2;
        int leftVal = query(2*i+1, start, mid, left, right);
        int rightVal = query(2*i+2, mid+1, end, left, right);
        return leftVal ^ rightVal;
    }
}

class Solution {
    int n;
    List<List<Integer>> adj;
    int[] tin;
    int[] tout;
    int[] euler;
    int time;
    int[] depths;
    int[][] parent;
    int col;

    public List<Boolean> palindromePath(int n, int[][] edges, String s, String[] queries) {
        this.n = n;
        adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] x : edges) {
            adj.get(x[0]).add(x[1]);
            adj.get(x[1]).add(x[0]);
        }

        tin = new int[n];
        tout = new int[n];
        euler = new int[n + n];
        time = 0;
        col = 32 - Integer.numberOfLeadingZeros(n);
        depths = new int[n];
        parent = new int[n][col];
        for (int[] x : parent) {
            Arrays.fill(x, -1);
        }

        DFS(0, -1, 0, s);
        buildAncestor();

        SegmentTree st = new SegmentTree(euler);
        List<Boolean> result = new ArrayList<>();
        for(String str: queries) {
            String[] arr = str.split(" ");
            if(arr[0].equals("update")) {
                int index = Integer.parseInt(arr[1]);
                char ch = arr[2].charAt(0);

                int value = 1 << (ch - 'a');
                st.update(tin[index], value);
                st.update(tout[index], value);
                StringBuilder sb = new StringBuilder(s);
                sb.setCharAt(index, ch);
                s = sb.toString();
            } else {
                int u = Integer.parseInt(arr[1]);
                int v = Integer.parseInt(arr[2]);
                int LCA = getLCA(u, v);
                char ch = s.charAt(LCA);
                int charVal = 1 << (ch -'a');
                int mask = st.query(0, tin[u]) ^ st.query(0, tin[v]) ^ charVal;
                result.add((mask & (mask - 1)) == 0); 
            }
        }

        return result;
    }

    int getAncestor(int node, int k) {
        for(int j=0;j<col;j++) {
            if((k & (1 << j)) != 0) {
                node = parent[node][j];
                if(node == -1) {
                    return -1;
                }
            }
        }

        return node;
    }

    int getLCA(int u, int v) {
        if(depths[u] != depths[v]) {
            if(depths[u] > depths[v]) {
                u = getAncestor(u, depths[u] - depths[v]);
            } else {
                v = getAncestor(v, depths[v] - depths[u]);
            }
        }

        if(u == v) {
            return u;
        }

        for(int j=col-1;j>=0;j--) {
            if(parent[u][j] == -1) {
                continue;
            }

            if(parent[u][j] != parent[v][j]) {
                u = parent[u][j];
                v = parent[v][j];
            }
        }

        return parent[u][0];
    }

    void buildAncestor() {
        for(int j=1;j<col;j++) {
            for(int node = 0;node<n;node++) {
                if(parent[node][j-1] != -1) {
                    parent[node][j] = parent[parent[node][j-1]][j-1];
                }
            }
        }
    }

    void DFS(int source, int par, int depth, String s) {
        depths[source] = depth;
        parent[source][0] = par;
        tin[source] = time;
        euler[time] = 1 << (s.charAt(source) - 'a');
        time++;

        for (int x : adj.get(source)) {
            if (x == par) {
                continue;
            }
            DFS(x, source, depth + 1, s);
        }

        tout[source] = time;
        euler[time] = 1 << (s.charAt(source) - 'a');
        time++;
    }
}
