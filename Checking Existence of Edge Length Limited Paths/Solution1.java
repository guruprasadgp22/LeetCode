class Solution {
    int[] parent;
    int[] rank;

    private void union(int x, int y) {
        int parentX = find(x);
        int parentY = find(y);

        if(parentX == parentY) {
            return;
        }

        if(rank[parentX] == rank[parentY]) {
            parent[parentY] = parentX;
            rank[parentX]++;
        } else if(rank[parentX] > rank[parentY]) {
            parent[parentY] = parentX;
        } else {
            parent[parentX] = parentY;
        }
    }

    private int find(int x) {
        if(parent[x] == x) {
            return x;
        }

        return find(parent[x]);
    }

    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        int q = queries.length;
        int[][] query = new int[q][4];
        for(int i=0;i<q;i++) {
            query[i][0] = queries[i][0];
            query[i][1] = queries[i][1];
            query[i][2] = queries[i][2];
            query[i][3] = i;
        }

        Arrays.sort(query, (a, b) -> {
            if(a[2] == b[2]) {
                if(a[1] == b[1]) {
                    return Integer.compare(a[0], b[0]);
                }
                return Integer.compare(a[1], b[1]);
            }

            return Integer.compare(a[2], b[2]);
        });

        Arrays.sort(edgeList, (a, b) -> {
            if(a[2] == b[2]) {
                if(a[1] == b[1]) {
                    return Integer.compare(a[0], b[0]);
                }

                return Integer.compare(a[1], b[1]);
            }

            return Integer.compare(a[2], b[2]);
        });

        boolean[] result = new boolean[q];
        int j = 0;
        parent = new int[n];
        for(int i=0;i<n;i++) {
            parent[i] = i;
        }
        rank = new int[n];

        for(int i=0;i<q;i++) {
            int[] temp = query[i];
            int u = temp[0];
            int v = temp[1];
            int w = temp[2];
            int idx = temp[3];

            while(j < edgeList.length && edgeList[j][2] < w) {
                union(edgeList[j][0], edgeList[j][1]);
                j++;
            }

            if(find(u) == find(v)) {
                result[idx] = true;
            } else {
                result[idx] = false;
            }
        }

        return result;
    }
}
