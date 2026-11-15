class Solution {
    int rows;
    int cols;
    int[][] parent;

    public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }

        Arrays.sort(arr, (a, b) -> {
            return Integer.compare(a[0], b[0]);
        });

        int[] nodeToIndex = new int[n];
        for (int i = 0; i < n; i++) {
            int node = arr[i][1];
            nodeToIndex[node] = i;
        }

        rows = n;
        cols = (int) (Math.log(n) / Math.log(2)) + 1;
        parent = new int[rows][cols];
        for (int node = 0; node < n; node++) {
            int far = binarySearch(arr, arr[node][0] + maxDiff);
            parent[node][0] = far;
        }
        build();

        int q = queries.length;
        int[] res = new int[q];
        int idx = 0;

        for (int[] x : queries) {
            int u = x[0];
            int v = x[1];

            int a = nodeToIndex[u];
            int b = nodeToIndex[v];

            if (a == b) {
                res[idx++] = 0;
                continue;
            }

            if (a > b) {
                int t = a;
                a = b;
                b = t;
            }

            int jumps = 0;
            int curr = a;
            for (int j = cols - 1; j >= 0; j--) {
                if (parent[curr][j] < b) {
                    curr = parent[curr][j];
                    jumps += (1 << j);
                }
            }

            if (parent[curr][0] >= b) {
                res[idx++] = jumps + 1;
            } else {
                res[idx++] = -1;
            }
        }

        return res;
    }

    private void build() {
        for (int j = 1; j < cols; j++) {
            for (int node = 0; node < rows; node++) {
                parent[node][j] = parent[parent[node][j - 1]][j - 1];
            }
        }
    }

    private int binarySearch(int[][] arr, int target) {
        int res = 0;
        int low = 0;
        int high = rows - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid][0] <= target) {
                res = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return res;
    }
}
